//imports
import java.util.Random;

class SimpleThread extends Thread{

    private final int MAX_DISTANCE = 100;
    public int threadNumber = HorseRace.horses;
    Random generator;

    //-----------------------------------------------
    public SimpleThread() {
        generator = new Random();
    }//end Constructor

    public void run(){
        int randomNumber;
        int strideDistance = 0;

        setName("Horse #");

        System.out.println(this.getName());

        while (strideDistance < MAX_DISTANCE) {

            randomNumber = generator.nextInt(5);
            strideDistance = strideDistance + randomNumber + 6;

            if (strideDistance < MAX_DISTANCE)
                System.out.println(this.getName() + this.getId()+ ": " + strideDistance);

            else
                System.out.println(this.getName() + this.getId()+ ": " + strideDistance + "*********");

        }//end while

        System.out.println(this.getName() + ": Wahoo! Finally done!!");
        HorseRace.message = this.getName();
    }//end method

}//end class
