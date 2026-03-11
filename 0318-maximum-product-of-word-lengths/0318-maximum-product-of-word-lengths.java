class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        int[] len = new int[n];
        
        for (int i = 0; i < n; i++) {
            int bitmask = 0;
            for (char c : words[i].toCharArray()) {
                bitmask |= 1 << (c - 'a');
            }
            mask[i] = bitmask;
            len[i] = words[i].length();
        }
        
        int maxProduct = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    maxProduct = Math.max(maxProduct, len[i] * len[j]);
                }
            }
        }
        
        return maxProduct;
    }
}