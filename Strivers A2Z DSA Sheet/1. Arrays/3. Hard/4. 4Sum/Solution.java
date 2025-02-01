// https://leetcode.com/problems/4sum/description/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1])
                    continue;
                int k = j+1;
                int l = length-1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++; l--;
                        while (k < l && nums[k] == nums[k-1])
                            k++;
                        while (k < l && nums[l] == nums[l+1])
                            l--;
                    }
                }
            }
        }
        return ans;
    }
}

// https://leetcode.com/problems/4sum/solutions/8609/my-solution-generalized-for-ksums-in-java/