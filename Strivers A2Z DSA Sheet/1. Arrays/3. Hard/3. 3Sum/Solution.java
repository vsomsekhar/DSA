// https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        
        for (int i = 0; i < length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i+1;
            int k = length-1;

            while (j < k) {

                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));

                    int tempj = nums[j];
                    while (tempj == nums[j] && j < k) {
                        j++;
                    }
                    int tempk = nums[k];
                    while (tempk == nums[k] && j < k) {
                        k--;
                    }
                } 
                else if (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else if (nums[i] + nums[j] + nums[k] < 0)
                    j++;

            }

        }

        return ans;
    }
}

// https://leetcode.com/problems/3sum/solutions/5055810/video-two-pointer-solution/