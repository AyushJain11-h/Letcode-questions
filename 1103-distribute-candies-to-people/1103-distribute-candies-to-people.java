
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];

        int give = 1;
        int i = 0;

        while (candies > 0) {
            int amount = Math.min(candies, give);

            result[i % num_people] += amount;
            candies -= amount;

            give++;
            i++;
        }

        return result;
    }
}
