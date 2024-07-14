class Solution {
    public static int largest(int n, int[] arr) {
        // code here
        int largest = 0;

        if (arr.length == 1)
            return arr[0];

        for (int i=0; i<n; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }

        return largest;
    }
}

https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0
