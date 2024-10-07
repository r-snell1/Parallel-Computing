public class ChainThreads {

    //to determine the level of the chain
    public static int count = 0;

    public static void main(String[] args) {

        int nbrOfThreads = Integer.parseInt(args[0]);  // Number of threads to create

        Thread parentThread = new Thread(() -> createChildThreads(nbrOfThreads));
        parentThread.start();

        System.out.println("Main thread ID: " + Thread.currentThread().getId() + " started the chain.");

    }//end main

    public static void createChildThreads(int depth) {

        if (depth <= 0) {
            return;  // Base case: stop creating threads when depth is zero
        }

        //iterates the chain count
        count++;

        Thread childThread = new Thread(() -> {
            System.out.println("Thread Level: " + count + " Child thread ID: " + Thread.currentThread().getId() + " Depth: " + depth);
            createChildThreads(depth - 1);  // Create the next thread in the chain
        });

        childThread.start();

    }//end method

}//end class