class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        int[] match = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            match[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            if (s.startsWith(sources[i], idx)) {
                match[idx] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (match[i] >= 0) {
                int j = match[i];
                result.append(targets[j]);
                i += sources[j].length();
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}