import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store value -> index mapping
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // number we need to find

            // If complement already exists in map, return the indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current number and its index
            map.put(nums[i], i);
        }

        // If no solution is found (shouldn't happen per problem statement)
        return new int[] {};
    }
}
