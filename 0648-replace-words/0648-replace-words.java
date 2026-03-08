import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    public String findRoot(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return word;
            }
            prefix.append(c);
            node = node.children[index];

            if (node.isWord) {
                return prefix.toString();
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary) {
            insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(findRoot(word)).append(" ");
        }

        return result.toString().trim();
    }
}