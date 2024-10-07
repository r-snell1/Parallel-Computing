//imports
import java.util.Random;

class Players extends Thread{

    private final int MAX_DISTANCE = 100;
    Random generator;

    //-----------------------------------------------
    public Players() {
        generator = new Random();
    }//end Constructor

    public void run(){

        int randomNumber;
        int distanceSoFar = 0;
        System.out.println("I am the child thread. Name: " + this.getName());

        while (distanceSoFar < MAX_DISTANCE) {

            randomNumber = generator.nextInt(20);
            distanceSoFar = distanceSoFar + randomNumber;

            if (distanceSoFar < MAX_DISTANCE)
                System.out.println(this.getName() + ": " + distanceSoFar);
            else
                System.out.println(this.getName() + ": " + distanceSoFar + "*********");

        }//end while

        System.out.println(this.getName() + ": Wahoo! Finally done!!");
        GameDriver.message = this.getName();

    }//end method

}//end extends Thread class
