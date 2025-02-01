// https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> answer = new ArrayList<>();

        for(int row = 1; row <= numRows; row++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int ans = 1;
            for(int column = 1; column < row; column++) {
                ans = ans * (row - column);
                ans = ans / column;
                list.add(ans);
            }
            answer.add(list);
        }

        return answer;
    }
}

// https://leetcode.com/problems/pascals-triangle/solutions/4016203/three-approaches-beginner-friendly-full-explanation-c-java-python/

// intuition: Pascal's triangle can also be generated using combinatorial formula C(n, k) = C(n-1, k-1) + C(n-1, k), 
// where C(n, k) represents the binomial coefficient. We can calculate each element of the triangle using this formula. 
// This approach avoids the need for storing the entire triangle in memory, making it memory-efficient.