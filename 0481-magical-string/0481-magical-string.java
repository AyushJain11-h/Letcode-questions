class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;

        int head = 2; // read pointer
        int tail = 3; // write pointer
        int num = 1;  // next number to fill
        int countOnes = 1;

        while (tail < n) {
            int times = arr[head];

            for (int i = 0; i < times && tail < n; i++) {
                arr[tail] = num;
                if (num == 1) countOnes++;
                tail++;
            }

            num = (num == 1) ? 2 : 1; // switch
            head++;
        }

        return countOnes;
    }
}