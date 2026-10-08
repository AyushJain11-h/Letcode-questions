class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int totalDistance = 0;
        int clockwiseDistance = 0;

        // Calculate total distance of the circular route
        for (int d : distance) {
            totalDistance += d;
        }

        // Calculate distance from start to destination
        int i = start;

        while (i != destination) {
            clockwiseDistance += distance[i];
            i = (i + 1) % distance.length;
        }

        // The other direction
        int counterClockwiseDistance = totalDistance - clockwiseDistance;

        return Math.min(clockwiseDistance, counterClockwiseDistance);
    }
}
