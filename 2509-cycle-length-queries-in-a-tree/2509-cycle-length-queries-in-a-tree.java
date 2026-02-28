class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int steps = 0;

            while (a != b) {
                if (a > b) {
                    a /= 2;
                } else {
                    b /= 2;
                }
                steps++;
            }

            result[i] = steps + 1;
        }

        return result;
    }
}