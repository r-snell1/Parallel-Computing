//class Listen extends Thread {
//
//    private final SharedQueue sharedQueue;
//    private int lCount;
//    private int lWait;
//
//    public Listen (SharedQueue sharedQueue, int count, int duration) {
//        this.sharedQueue = sharedQueue;
//        this.lCount = count;
//        this.lWait = duration;
//    }//end constructor
//
//    @Override
//    public void run() {
//        try {
//            for (int i = 0; i < lCount; i++) {
//                sharedQueue.listen(i);
//                Thread.sleep(lWait);
//            }//end for
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }//end try catch
//
//    }//end override method
//
//}//end class extends