import java.util.*;

class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        
        // Map each skill to a bit index
        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillMap.put(req_skills[i], i);
        }
        
        // DP: key = skill mask, value = list of people indices
        Map<Integer, List<Integer>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());
        
        for (int i = 0; i < people.size(); i++) {
            int personMask = 0;
            
            // Create skill mask for current person
            for (String skill : people.get(i)) {
                if (skillMap.containsKey(skill)) {
                    personMask |= 1 << skillMap.get(skill);
                }
            }
            
            // Copy current DP state to avoid concurrent modification
            Map<Integer, List<Integer>> newDp = new HashMap<>(dp);
            
            for (int mask : dp.keySet()) {
                int combined = mask | personMask;
                
                // If new combination improves team size
                if (!newDp.containsKey(combined) ||
                        newDp.get(combined).size() > dp.get(mask).size() + 1) {
                    
                    List<Integer> team = new ArrayList<>(dp.get(mask));
                    team.add(i);
                    newDp.put(combined, team);
                }
            }
            
            dp = newDp;
        }
        
        List<Integer> result = dp.get((1 << n) - 1);
        
        // Convert List<Integer> to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        
        return ans;
    }
}