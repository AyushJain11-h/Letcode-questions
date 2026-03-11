import java.util.Arrays;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int count = 0;
        int first = -1, second = -1;

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];

            if (start > second) {
                count += 2;
                first = end - 1;
                second = end;
            } 
            else if (start > first) {
                count += 1;
                first = second;
                second = end;
            }
        }

        return count;
    }
}