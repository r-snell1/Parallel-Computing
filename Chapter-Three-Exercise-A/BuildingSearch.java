import java.util.Random;

public class BuildingSearch {
    public static final int MAX_FLOORS = 1000;
    public static final int MAX_SIDE_LENGTH = 10;
    private static final int MAX_BUFFER_SIZE = 40;
    private static final int FALSE = 0;
    private static final int TRUE = 1;

    private static final int[][][] building = new int[MAX_FLOORS][MAX_SIDE_LENGTH][MAX_SIDE_LENGTH];

    public static void main(String[] args) {
        int floorCount = 0;

        if (args.length != 1) {
            System.err.printf("\nUsage: java BuildingSearch #floors(1-%d)\n", MAX_FLOORS);
            System.exit(1);
        } else {
            floorCount = Integer.parseInt(args[0]);
        }

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        hidePerson(floorCount);
        searchBuilding(floorCount);
    }

    private static void hidePerson(int nbrFloors) {
        // Implementation of hiding a person in the building
        // For example, randomly placing a person in the building
        Random random = new Random();
        int floor = random.nextInt(nbrFloors);
        int x = random.nextInt(MAX_SIDE_LENGTH);
        int y = random.nextInt(MAX_SIDE_LENGTH);
        building[floor][x][y] = TRUE; // Marking the position where the person is hidden
    }

    private static void searchBuilding(int nbrFloors) {
        Thread[] threads = new Thread[nbrFloors];

        for (int i = 0; i < nbrFloors; i++) {
            final int floor = i;
            threads[i] = new Thread(() -> searchFloor(floor));
            threads[i].start();
        }

        for (int i = 0; i < nbrFloors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void searchFloor(int floor) {
        // Implementation of searching a specific floor
        for (int x = 0; x < MAX_SIDE_LENGTH; x++) {
            for (int y = 0; y < MAX_SIDE_LENGTH; y++) {
                if (building[floor][x][y] == TRUE) {
                    System.out.printf("Person found on floor %d at position (%d, %d)\n", floor, x, y);
                    return; // Person found, exit the search
                }
            }
        }
        System.out.printf("No person found on floor %d\n", floor);
    }
}

