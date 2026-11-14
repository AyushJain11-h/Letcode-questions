
class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ch++) {
                    if ((i > 0 && arr[i - 1] == ch) ||
                        (i < arr.length - 1 && arr[i + 1] == ch)) {
                        continue;
                    }

                    arr[i] = ch;
                    break;
                }
            }
        }

        return new String(arr);
    }
}
