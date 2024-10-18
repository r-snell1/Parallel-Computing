public class FloorSearch {
    private static final int MAX_BUFFER_SIZE = 1024;
        private static final int FALSE = 0;

    static boolean[][][] building = new boolean[BuildingSearch.MAX_FLOORS][BuildingSearch.MAX_SIDE_LENGTH][BuildingSearch.MAX_SIDE_LENGTH];

    public static Integer floorSearch(Integer floorPtr) {
        char[] buffer = new char[MAX_BUFFER_SIZE];
        for (int i = 0; i < MAX_BUFFER_SIZE; i++) {
            buffer[i] = '\0'; // Null byte
        }

        int floor = floorPtr;
        Integer resultPtr = new Integer(0);

        // Check each room on the floor
        for (int row = 0; row < BuildingSearch.MAX_SIDE_LENGTH; row++) {
            for (int column = 0; column < BuildingSearch.MAX_SIDE_LENGTH; column++) {
                if (Thread.interrupted()) {
                    return resultPtr;
                }
                if (building[floor][row][column]) {
                    resultPtr = row * 10 + column;
                    return resultPtr;
                }
            }
        }

        resultPtr = FALSE;
        return resultPtr;
    }
}
