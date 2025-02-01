// https://leetcode.com/problems/subarray-sum-equals-k/solutions/803317/java-solution-with-detailed-explanation/

// add 1 to the map for the sum 0, because we can have a subarray starting from index 0 to any index i with sum k.
// first increase the count then add the sum to the map, because sumsCount.put can overwrite the value of the sum.


class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> sumsCount = new HashMap<>();
        sumsCount.put(0,1);

        for(int i = 0; i < nums.length; i++) {
            
            currentSum = currentSum + nums[i];

            if (sumsCount.containsKey(currentSum - k)) {
                count = count + sumsCount.get(currentSum - k);
            }

            if (sumsCount.containsKey(currentSum))
                sumsCount.put(currentSum, sumsCount.get(currentSum)+1);
            else 
                sumsCount.put(currentSum, 1);
 
        }

        return count;
    }
}

// Algorithm / Intuition
// In this approach, we are going to use the concept of the prefix sum to solve this problem. 
// Here, the prefix sum of a subarray ending at index i simply means the sum of all the elements of that subarray.

// Observation:

// Assume, the prefix sum of a subarray ending at index i is x. 
// In that subarray, we will search for another subarray ending at index i, whose sum equals k.
// Here, we need to observe that if there exists another subarray ending at index i with sum k, 
// then the prefix sum of the rest of the subarray will be x-k. The below image will clarify the concept:

// Now, for a subarray ending at index i with the prefix sum x, if we remove the part with the prefix sum x-k, we will be left with the part whose sum is equal to k. And that is what we want.

// Now, there may exist multiple subarrays with the prefix sum x-k. So, the number of subarrays with sum k that we can generate from the entire subarray ending at index i, is exactly equal to the number of subarrays with the prefix sum x-k, that we can remove from the entire subarray.

// That is why, instead of searching the subarrays with sum k, we will keep the occurrence of the prefix sum of the subarrays using a map data structure. 

// In the map, we will store every prefix sum calculated, with its occurrence in a <key, value> pair. Now, at index i, we just need to check the map data structure to get the number of times that the subarrays with the prefix sum x-k occur. Then we will simply add that number to our answer.

// We will apply the above process for all possible indices of the given array. The possible values of the index i can be from 0 to n-1(where n = size of the array).

// Approach:

// The steps are as follows:

// First, we will declare a map to store the prefix sums and their counts.
// Then, we will set the value of 0 as 1 on the map.
// Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
// For each index i, we will do the following:
// We will add the current element i.e. arr[i] to the prefix sum.
// We will calculate the prefix sum i.e. x-k, for which we need the occurrence.
// We will add the occurrence of the prefix sum x-k i.e. mpp[x-k] to our answer.
// Then we will store the current prefix sum in the map increasing its occurrence by 1.
// Question: Why do we need to set the value of 0?
// Let’s understand this using an example. Assume the given array is [3, -3, 1, 1, 1] and k is 3. Now, for index 0, we get the total prefix sum as 3, and k is also 3. So, the prefix sum of the remove-part should be x-k = 3-3 = 0. Now, if the value is not previously set for the key 0 in the map, we will get the default value 0 for the key 0 and we will add 0 to our answer. This will mean that we have not found any subarray with sum 3 till now. But this should not be the case as index 0 itself is a subarray with sum k i.e. 3.
// So, in order to avoid this situation we need to set the value of 0 as 1 on the map beforehand.