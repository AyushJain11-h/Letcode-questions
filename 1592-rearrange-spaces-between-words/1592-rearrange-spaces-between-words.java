class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0;
        String[] words = text.trim().split("\\s+");

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaces++;
            }
        }

        if (words.length == 1) {
            return words[0] + " ".repeat(spaces);
        }

        int spacesBetween = spaces / (words.length - 1);
        int extraSpaces = spaces % (words.length - 1);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);

            if (i < words.length - 1) {
                result.append(" ".repeat(spacesBetween));
            }
        }

        result.append(" ".repeat(extraSpaces));

        return result.toString();
    }
}