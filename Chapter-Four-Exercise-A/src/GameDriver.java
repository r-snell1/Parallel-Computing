//imports
import java.util.ArrayList;


public class GameDriver {

    public static String message;

    public static void main(String[] args) {

        Players[] playersTable;
        ArrayList<String> phrase = new ArrayList<>();
        String temp;

        int numberOfThreads;

        if (args.length >= 5) {
            try {
                numberOfThreads = Integer.parseInt(args[0]);
                playersTable = new Players[numberOfThreads];
                temp = args[1];
                phrase.add(temp);
                temp = args[2];
                phrase.add(temp);
                temp = args[3];
                phrase.add(temp);
                temp = args[4];
                phrase.add(temp);

                for (int i = 0; i < numberOfThreads; i++) {
                    playersTable[i] = new Players();

                }//end for
            } catch (Exception e) {
                System.out.println("invalid number of threads and phrase words.");
                return;
            }

        } else {
            System.out.println("Usage: java GameDriver <threadNumber> <word> <word> <word> <word>");
            return;
        }// end if

        //start each thread
        for (int i = 0; i < numberOfThreads; i++) {
            playersTable[i].start();
        }//end for

        try {
            for (int i = 0; i < numberOfThreads; i++) {
                playersTable[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//end try catch

        System.out.println("Producer and Consumer have finished their tasks.");

    }//end main

}//end class
