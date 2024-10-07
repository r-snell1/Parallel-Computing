////imports
//import java.util.LinkedList;
//import java.util.Queue;
//
//class SharedQueue {
//
//    private final Queue<Integer> queue = new LinkedList<>();
//    private final int MAX_SIZE = 100; // Buffer size limit
//    private static final String ANSI_RED = "\u001B[31m";
//    private static final String ANSI_RESET = "\u001B[0m";
//
//    public synchronized void speak(int value) throws InterruptedException {
//
//        while (queue.size() == MAX_SIZE) {
//            wait();
//        }//end while
//
//        queue.add(value);
//        System.out.println("Spoken: " + value);
//        notifyAll();
//
//    }//end synchronized method
//
//    public synchronized void listen(int value) throws InterruptedException {
//
//        while (queue.size() == MAX_SIZE) {
//            wait();
//        }//end while
//
//        queue.add(value);
//        System.out.println("Listened: " + value);
//        notifyAll();
//
//    }//end synchronized method
//
//}//end class