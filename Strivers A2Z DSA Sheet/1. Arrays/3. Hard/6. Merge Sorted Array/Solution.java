// https://leetcode.com/problems/merge-sorted-array/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;         // Last valid index in nums1
        int j = n - 1;         // Last index in nums2
        int k = m + n - 1;     // Last index in nums1 (for merging)
        
        while (j >= 0) {       // Merge until all elements in nums2 are processed
            if (i >= 0 && nums1[i] > nums2[j]) {  
                nums1[k--] = nums1[i--];  // Place nums1[i] at k and move pointers
            } else {
                nums1[k--] = nums2[j--];  // Place nums2[j] at k and move pointers
            }
        }
    }
}

// Approach : Two Pointer
// We can start with two pointers i and j, initialized to m-1 and n-1, respectively. 
// We will also have another pointer k initialized to m+n-1, which will be used to keep 
// track of the position in nums1 where we will be placing the larger element. Then we 
// can start iterating from the end of the arrays i and j, and compare the elements at 
// these positions. We will place the larger element in nums1 at position k, and decrement 
// the corresponding pointer i or j accordingly. We will continue doing this until we have 
// iterated through all the elements in nums2. If there are still elements left in nums1, 
// we don't need to do anything because they are already in their correct place.

// Complexity
// Time complexity: O(m+n)
// We are iterating through both arrays once, so the time complexity is O(m+n).

// Space complexity: O(1)
// We are not using any extra space, so the space complexity is O(1).