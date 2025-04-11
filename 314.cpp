class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());

        for (int i = 0; i < nums.size() - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;  // Skip duplicate values for the first element

            int left = i + 1;
            int right = nums.size() - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if (total == 0) {
                    result.push_back({nums[i], nums[left], nums[right]});

                    // Move left and right to the next different numbers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (total < 0) {
                    left++;  // Need a larger number
                } else {
                    right--; // Need a smaller number
                }
            }
        }

        return result;
    }
};
