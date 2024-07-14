class Solution {
    public int print2largest(List<Integer> arr) {
        // Code Here
        int largest = 0;
        int secondLargest = -1;
        
        for (int i = 0; i < arr.size(); i++) {
            
            if (arr.get(i) > largest) {
                secondLargest = largest;
                largest = arr.get(i);
            } else if (arr.get(i) < largest && arr.get(i) > secondLargest) {
                secondLargest = arr.get(i);
            }
            
        }
        
        if (secondLargest == largest || arr.size() == 1)
            return -1;
        
        return secondLargest;
        
    }
}

https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest