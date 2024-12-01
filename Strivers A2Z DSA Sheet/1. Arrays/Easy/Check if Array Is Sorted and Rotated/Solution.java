// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int length = nums.length;

        for(int i = 0; i < length; i++) {
            if (nums[i] > nums[(i+1) % length]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
        
    }
}

class Solution {
    public boolean check(int[] nums) {
        // here we compare all the neighbouring elemnts and check whether they are in somewhat sorted
        // there will be a small change due to rotation in the array at only one place.
        // so if there are irregularities more than once, return false
        // else return true;
        int irregularities = 0;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            if (nums[i] > nums[(i + 1) % length])
                irregularities += 1;
        }
        return irregularities > 1 ? false : true;
    }
}

// 3 4 5 1 2

// 1 % 5 = 1
// 2 % 5 = 2
// 3 % 5 = 3
// 4 % 5 = 4
// 5 % 5 = 0