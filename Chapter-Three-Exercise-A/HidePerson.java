public class HidePerson {

    public void hidePerson(int nbrFloors) {
        int floor;
        int row;
        int column;
        int room;

        for (floor = 0; floor < nbrFloors; floor++) {
            for (row = 0; row < BuildingSearch.MAX_SIDE_LENGTH; row++) {
                for (column = 0; column < BuildingSearch.MAX_SIDE_LENGTH; column++) {
                    FloorSearch.building[floor][row][column] = false;
                }
            }
        }

        // Pick a random location to hide the person
        floor = (int) (Math.random() * nbrFloors);
        row = (int) (Math.random() * BuildingSearch.MAX_SIDE_LENGTH);
        column = (int) (Math.random() * BuildingSearch.MAX_SIDE_LENGTH);

        FloorSearch.building[floor][row][column] = true;
        room = row * 10 + column;
        System.err.println("\n(Hiding location)  Floor: " + floor + "  Room: " + room + "\n");
    }
}
