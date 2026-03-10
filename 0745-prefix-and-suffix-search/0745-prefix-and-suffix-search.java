import java.util.*;

class WordFilter {

    private Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();

        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int len = word.length();

            for (int i = 0; i <= len; i++) {
                String prefix = word.substring(0, i);
                for (int j = 0; j <= len; j++) {
                    String suffix = word.substring(len - j);
                    map.put(prefix + "#" + suffix, index);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(pref + "#" + suff, -1);
    }
}