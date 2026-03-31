class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();
        
        // Special candidates
        java.util.Set<Long> candidates = new java.util.HashSet<>();
        candidates.add((long)Math.pow(10, len - 1) - 1); // 999... case
        candidates.add((long)Math.pow(10, len) + 1);     // 100...001 case
        
        // Get prefix
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        
        // Generate palindrome candidates
        for (long i = prefix - 1; i <= prefix + 1; i++) {
            String p = String.valueOf(i);
            StringBuilder sb = new StringBuilder(p);
            
            // If odd length, skip the last digit while mirroring
            String secondHalf = (len % 2 == 0) ? sb.reverse().toString()
                                               : sb.deleteCharAt(sb.length() - 1).reverse().toString();
            
            String palindrome = p + secondHalf;
            candidates.add(Long.parseLong(palindrome));
        }
        
        candidates.remove(num); // Exclude itself
        
        long closest = -1;
        for (long cand : candidates) {
            if (closest == -1 ||
                Math.abs(cand - num) < Math.abs(closest - num) ||
                (Math.abs(cand - num) == Math.abs(closest - num) && cand < closest)) {
                closest = cand;
            }
        }
        
        return String.valueOf(closest);
    }
}