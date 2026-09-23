class Solution {
    public boolean rotateString(String s, String goal) {
        // Lengths must be equal
        if (s.length() != goal.length()) {
            return false;
        }

        // If goal is a rotation of s, it will be present in s + s
        String doubled = s + s;

        return doubled.contains(goal);
    }
}