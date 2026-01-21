
// https://leetcode.com/problems/set-matrix-zeroes/

// ✅ Intuition
// 	•	Use the first row and first column as markers to track which rows/columns need to be zeroed.
// 	•	Use a separate variable C0 to track if the first column needs to be zeroed.
// 	•	Process in 3 phases:
// 	•	Phase 1: Mark the first row/column based on zeros found in the matrix.
// 	•	Phase 2: Set zeros in the inner matrix based on the markers.
// 	•	Phase 3: Handle the first row and first column separately.

// ⏰ Time Complexity
// 	•	O(n × m) → We traverse the matrix multiple times, but each traversal is O(n × m).

// 🪴 Space Complexity
// 	•	O(1) → Constant extra space used (only using the matrix itself for marking).

class Solution {
    /**
     * Intuition:
     * To set entire rows and columns to zero efficiently:
     * - Use the first row and column as markers instead of extra space.
     * - Track separately if the first column needs to be zeroed (using C0 variable).
     * - Process the matrix in phases to avoid conflicts.
     */
    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int C0 = 1; // Flag to track if first column should be zeroed

        // Phase 1: Traverse the matrix and mark 1st row & 1st col as markers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {

                    // Mark i-th row in first column
                    matrix[i][0] = 0;

                    // Mark j-th column in first row (handle first column separately)
                    if (j == 0)
                        C0 = 0;
                    else
                        matrix[0][j] = 0;
                }
            }
        }

        // Phase 2: Set zeros in inner matrix based on markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {

                    // Check if this cell's row or column is marked for zeroing
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Phase 3: Handle first row and first column separately
        // Zero out first row if marked
        if (matrix[0][0] == 0) {
            java.util.Arrays.fill(matrix[0], 0);
        }
        // Zero out first column if marked
        if (C0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
