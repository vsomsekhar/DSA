class Solution{
    static int searchInSorted(int arr[], int N, int K)
    {
        // Your code here
        for (int i=0; i<N; i++) {
            if (arr[i] == K) {
                return 1;
            }
        }
        return -1;
    }
}

https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1