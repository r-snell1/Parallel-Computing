//imports
import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class FileProcessor {

    private static final int MAX_FILES = 5;
    private static final int BUFFER_SIZE = 80;

    public static void main(String[] args) {
        int nbrFiles = args.length;
        if (nbrFiles > MAX_FILES) {
            System.err.println("Exceeded maximum number of files: " + MAX_FILES);
            return;
        }//end if

        Path[] fileTable = new Path[nbrFiles];
        for (int i = 0; i < nbrFiles; i++) {
            fileTable[i] = Paths.get(args[i]);
            if (!Files.exists(fileTable[i]) || !Files.isReadable(fileTable[i])) {
                System.err.println("Failed to open file: " + args[i]);
            }//end if
        }//end for

        processFileTable(fileTable, nbrFiles);
    }//end main

    private static void processFileTable(Path[] files, int fileCount) {
        ExecutorService executor = Executors.newFixedThreadPool(fileCount);
        for (int i = 0; i < fileCount; i++) {
            final int index = i;
            executor.submit(() -> processFile(files[index]));
        }//end for
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.err.println("Thread execution interrupted: " + e.getMessage());
        }//end try catch
    }//end method

    private static void processFile(Path filePath) {
        try (BufferedInputStream inFile = new BufferedInputStream(Files.newInputStream(filePath))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int nbrBytes;
            while ((nbrBytes = inFile.read(buffer)) != -1) {
                processData(buffer, nbrBytes);
            }//end while
        } catch (IOException e) {
            System.err.println("Error processing file: " + filePath + " - " + e.getMessage());
        }//end try catch
    }//end method

    private static void processData(byte[] data, int dataSize) {
        System.out.write(data, 0, dataSize);
    }//end method

}// end class

