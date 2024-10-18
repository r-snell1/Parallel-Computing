import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SearchBuilding {
    public void searchBuilding(int nbrFloors) {

        ExecutorService executor = Executors.newFixedThreadPool(nbrFloors);
        ExecutorService executorService = Executors.newFixedThreadPool(nbrFloors);
        Future<Integer>[] futures = new Future[nbrFloors];
        Future<Integer>[] futureResults = new Future[nbrFloors];

        // Create a thread to search each floor
        for (int floor = 0; floor < nbrFloors; floor++) {
            int location = floor;
            futures[floor] = executorService.submit(() -> searchFloor(location));
        }

        // Wait for all threads to complete
        for (int floor = 0; floor < nbrFloors; floor++) {
            try {
                Integer foundPtr = futures[floor].get();
                // Handle the result
            } catch (Exception e) {
                System.err.printf("Failed to search floor %d: %s\n", floor, e.getMessage());
            }
        }
        for (int i = 0; i < nbrFloors; i++) {
            final int floor = i;
            futureResults[i] = executor.submit(() -> {
                // Simulate searching for a person in a room
                // This is a placeholder for the actual search logic
                return searchFloor(floor);
            });
        }

        // Check the search results returned by each thread
        for (int i = 0; i < nbrFloors; i++) {
            try {
                Integer foundRoom = futureResults[i].get();
                if (foundRoom == null) { // Check for a false condition
                    System.err.printf("(Floor %d) Nobody was found%n", i);
                } else {
                    if (foundRoom < 10) { // Adjust for insertion of zero in room number
                        System.err.printf("(Floor %d) Found person in Room %d0%d%n", i, i, foundRoom);
                    } else {
                        System.err.printf("(Floor %d) Found person in Room %d%d%n", i, i, foundRoom);
                    }
                    // Cancel remaining searches
                    for (int j = i + 1; j < nbrFloors; j++) {
                        futureResults[j].cancel(true);
                    }
                    System.err.println("\nAll remaining searches have been canceled");
                    break;
                }
            } catch (InterruptedException | ExecutionException e) {
                System.err.printf("Failed to join thread %d: %s%n", i, e.getMessage());
            }
        }

        executor.shutdown();
    }

    // Simulated search function for a floor
    private static Integer searchFloor(int floor) {
        // Simulate searching logic, returning a room number or null if not found
        // For demonstration, we randomly return a room number or null
        // In a real scenario, this would contain the actual search logic
        return (Math.random() > 0.5) ? (int) (Math.random() * 10) : null;
    }
}