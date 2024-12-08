// https://leetcode.com/problems/sort-colors/submissions/1471181450/

// my intuition was snowball approach

class Solution {
    public void sortColors(int[] nums) {

        if (nums.length < 2) {
            return;
        }

        int i = -1, j = 0;

        // first pass to move all 2s to the end
        while(j < nums.length) {
            if(nums[j] == 2) {
                if (i == -1)
                    i = j;
                j++; 
            } else {
                if (i > -1) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
                j++;
            }
        }

        i = -1; j = 0;

        // second pass to move all 1s till the beginning of 2s
        while(j < nums.length) {
            if (nums[j] == 2)
                return;
            if (nums[j] == 1) {          
                if (i == -1)
                    i = j;
                j++; 
            } else {
                if (i > -1) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
                j++;
            }
        }
        
    }
}

// The above snowball approach is bit complex, it can be simplified by counting the number of 0s, 1s and 2s and then filling the array with the counts
// then we can fill the array with the counts
// It will still be O(n) time complexity and O(1) space complexity


// [Expected Approach] Dutch National Flag Algorithm – One Pass – O(n) Time and O(1) Space
// The problem is similar to “Segregate 0s and 1s in an array”. The idea is to sort the array of size n using three pointers: lo = 0, mid = 0 and hi = n – 1 such that the array is divided into three parts –


// arr[0] to arr[lo – 1]: This part will have all the zeros.
// arr[lo] to arr[mid – 1]: This part will have all the ones.
// arr[hi + 1] to arr[n – 1]: This part will have all the twos.
// Here, lo indicates the position where next 0 should be placed, mid is used to traverse through the array and hi indicates the position where next 2 should be placed.


// Traverse over the array till mid <= hi, according to the value of arr[mid] we can have three cases:

// arr[mid] = 0, then swap arr[lo] and arr[mid] and increment lo by 1 because all the zeros are till index lo – 1 and move to the next element so increment mid by 1.
// arr[mid] = 1, then move to the next element so increment mid by 1.
// arr[mid] = 2, then swap arr[mid] and arr[hi] and decrement hi by 1 because all the twos are from index hi + 1 to n – 1. Now, we don’t move to the next element because the element which is now at index mid can be a 0 and therefore needs to be checked again.


class Solution {
    public void sortColors(int[] nums) {

        // 1-pass
        int low = 0, high = nums.length - 1, mid = 0;
        while (mid <= high) {
            if (nums[mid] == 0) {
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
            }
            if (nums[mid] == 2) {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
                mid--;
            }
            mid++;
        }
        
    }
}

// void sortColors(vector<int>& nums) {
//     int l = 0;
//     int m = 0;
//     int h = nums.size()-1;

//     while(m<=h){
//         if(nums[m]==0){
//             swap(nums[l], nums[m]);
//             l++;
//             m++;
//         }
//         else if(nums[m]==1){
//             m++;
//         }
//         else if(nums[m]==2){
//             swap(nums[m], nums[h]);
//             h--;
//         }
//     }
//  }