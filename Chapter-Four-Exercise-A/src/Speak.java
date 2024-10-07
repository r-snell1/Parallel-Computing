//class Speak extends Thread {
//
//    private final SharedQueue sharedQueue;
//    private int sCount;
//    private int sWait;
//
//    public Speak(SharedQueue sharedQueue, int count, int duration) {
//        this.sharedQueue = sharedQueue;
//        this.sCount = count;
//        this.sWait= duration;
//    }//end constructor
//
//    @Override
//    public void run() {
//        try {
//            for (int i = 0; i < sCount; i++) {
//                sharedQueue.speak(i);
//                Thread.sleep(sWait); // Simulates delay in production
//            }//end for
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }//end try catch
//
//    }//end override method
//
//}//end class extends