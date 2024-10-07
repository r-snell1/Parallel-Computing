public class FanThreads {

    //thread level determination
    public static int position = 0;

    public static void main(String[] args) {

        int nbrOfThreads = Integer.parseInt(args[0]);

        for (int i = 1; i < nbrOfThreads; i++) {

            Thread childThread = new Thread(new Runnable() {

                @Override public void run() {
                    position++;
                    System.out.println("Thread Position: " + position + " Thread ID: " + Thread.currentThread().getId() + " is running.");

                }
            });

            childThread.start();

        }//end for

        System.out.println("Main ID: " + Thread.currentThread().getId() + " has fanned all threads.");

    }//end main

}//end class