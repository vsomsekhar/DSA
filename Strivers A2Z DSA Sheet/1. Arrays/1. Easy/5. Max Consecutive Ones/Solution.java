// https://leetcode.com/problems/max-consecutive-ones/submissions/1468861159/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int currentMax = 0;
        int max = 0;
        int i = 0;

        while(i < nums.length) {

            if (nums[i] == 0){
                currentMax = 0;
            } 
            else {
                currentMax++;
                if (currentMax > max){
                    max = currentMax;
                }
            }
            i++;
        }

        return max;
        
    }
}

// Java 4 lines concise solution with explanation

public int findMaxConsecutiveOnes(int[] nums) {
    int maxHere = 0, max = 0;
    for (int n : nums)
        max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
    return max; 
} 

// The idea is to reset maxHere to 0 if we see 0, otherwise increase maxHere by 1
// The max of all maxHere is the solution

// 110111
// ^ maxHere = 1

// 110111
// .^ maxHere = 2

// 110111
// ..^ maxHere = 0

// 110111
// ...^ maxHere = 1

// 110111
// ....^ maxHere = 2

// 110111
// .....^ maxHere = 3