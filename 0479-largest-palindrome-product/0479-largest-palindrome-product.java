class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;

        int upper = (int)Math.pow(10, n) - 1;
        int lower = (int)Math.pow(10, n - 1);

        for (long left = upper; left >= lower; left--) {

            long palindrome = createPalindrome(left);

            for (long i = upper; i * i >= palindrome; i--) {
                if (palindrome % i == 0) {
                    long other = palindrome / i;
                    if (other >= lower && other <= upper) {
                        return (int)(palindrome % 1337);
                    }
                }
            }
        }
        return -1;
    }

    private long createPalindrome(long num) {
        long palindrome = num;
        long temp = num;

        while (temp > 0) {
            palindrome = palindrome * 10 + temp % 10;
            temp /= 10;
        }

        return palindrome;
    }
}