class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int left = 0;
        int ans = 0;
        int maxOccurance = 0;
        int[] freq = new int[26];

        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            maxOccurance = Math.max(maxOccurance, freq[s.charAt(right) - 'A']);

            while((right - left + 1) - maxOccurance > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}