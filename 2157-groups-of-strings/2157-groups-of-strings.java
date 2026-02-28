import java.util.*;

class Solution {

    static class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;

            if (size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
            } else {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
        }
    }

    public int[] groupStrings(String[] words) {
        int n = words.length;
        DSU dsu = new DSU(n);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= 1 << (c - 'a');
            }

            if (map.containsKey(mask)) {
                dsu.union(i, map.get(mask));
            }

            // Remove or add one character
            for (int b = 0; b < 26; b++) {
                int newMask = mask ^ (1 << b);
                if (map.containsKey(newMask)) {
                    dsu.union(i, map.get(newMask));
                }
            }

            // Replace one character
            for (int b1 = 0; b1 < 26; b1++) {
                if ((mask & (1 << b1)) == 0) continue;
                for (int b2 = 0; b2 < 26; b2++) {
                    if ((mask & (1 << b2)) != 0) continue;
                    int newMask = mask ^ (1 << b1) ^ (1 << b2);
                    if (map.containsKey(newMask)) {
                        dsu.union(i, map.get(newMask));
                    }
                }
            }

            map.put(mask, i);
        }

        Map<Integer, Integer> groupCount = new HashMap<>();
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            groupCount.put(root, groupCount.getOrDefault(root, 0) + 1);
            maxSize = Math.max(maxSize, groupCount.get(root));
        }

        return new int[]{groupCount.size(), maxSize};
    }
}