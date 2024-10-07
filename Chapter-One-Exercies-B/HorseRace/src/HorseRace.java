public class HorseRace {

    public static String message;

    public static int horses;

    public static void main(String[] args) {

        SimpleThread[] threadTable;


        int numberOfThreads;

        if (args.length == 0) {
            System.out.println("Usage: java ThreadDriver <threadNumber>");
            return;
        }//end if
        else {
            numberOfThreads = Integer.parseInt(args[0]);
            threadTable = new SimpleThread[numberOfThreads];
            horses = numberOfThreads;
            for (int i = 0; i < numberOfThreads; i++) {
                threadTable[i] = new SimpleThread();
            }//end for

        }//end else

        System.out.println("And they're off!!!");

        //start each thread
        for (int i = 0; i < numberOfThreads; i++) {
            threadTable[i].start();
        }//end for

    }//end main



}
