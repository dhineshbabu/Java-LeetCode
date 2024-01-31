package neetcode150.prob04_stack;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Prob06_LC853CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {
        // Use TreeMap with reverse order to store position and corresponding time
        // TreeMap is used to automatically sort the positions in reverse order
        // (from right to left on the road) for easier processing
        Map<Integer, Double> timeMap = new TreeMap<>(Collections.reverseOrder());

        // Calculate and store time taken by each vehicle to reach the target
        for (int i = 0; i < position.length; i++) {
            timeMap.put(position[i], (double) (target - position[i]) / speed[i]);
        }

        // Initialize variables
        int fleets = 0;
        double currentVehicleTime = 0.0;

        // Iterate through the sorted map and calculate fleet groups
        for (double time : timeMap.values()) {
            if (time > currentVehicleTime) {
                currentVehicleTime = time;
                fleets++; // Increment fleets as this is a new fleet
            }
        }

        return fleets; // Return the total number of fleets
    }

    public static void main(String[] args) {

        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        int result = carFleet(target, position, speed);
        System.out.println("Number of car fleets: " + result);
    }
}
