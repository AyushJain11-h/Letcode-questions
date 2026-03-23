class Solution {
    public int secondHighest(String s) {
        int largest = -1;
        int secondLargest = -1;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int num = c - '0';
                
                if (num > largest) {
                    secondLargest = largest;
                    largest = num;
                } else if (num < largest && num > secondLargest) {
                    secondLargest = num;
                }
            }
        }
        
        return secondLargest;
    }
}