// https://leetcode.com/problems/rotate-image/submissions/1482014323/

class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}

// Intuition

// The intuition behind rotating a matrix 90 degrees clockwise revolves around visualizing the matrix as a set of concentric square layers. 
// Each layer consists of elements that form a border around the current smaller matrix. 
// To perform the rotation, we observe that elements from the top row move to the right column, elements from the right column move to the bottom row (in reverse order), 
// elements from the bottom row move to the left column (in reverse order), and elements from the left column move to the top row. This movement follows a cyclic pattern. 
// Instead of creating a new matrix, the algorithm uses in-place swapping to achieve this rotation. For each layer, the algorithm processes elements in groups of four by temporarily saving one value, then shifting the others in a clockwise direction. 
// This approach ensures that no data is lost during the rotation. By iterating through all layers and performing these swaps, the entire matrix is transformed in an efficient manner without requiring extra space. 
// This method leverages the inherent symmetry of the matrix to achieve the rotation with minimal operations.

// https://leetcode.com/problems/rotate-image/

// Idea:
// The trick here is to realize that cells in our matrix (M) can be swapped out in groups of four in a self-contained manner. This will allow us to keep our space complexity down to O(1).

// The remaining difficulty lies in setting up our nested for loops to accomplish the entirety of these four-way swaps. If we consider each ring of data as a larger iteration, we can notice that each successive ring shortens in the length of its side by 2. This means that we will need to perform this process to a maximum depth of floor(n / 2) times. We can use floor here because the center cell of an odd-sided matrix will not need to be swapped.

// For each ring, we'll need to perform a number of iterations equal to the length of the side minus 1, since we will have already swapped the far corner as our first iteration. As noticed earlier, the length of the side of a ring is shortened by 2 for each layer of depth we've achieved (len = n - 2 * i - 1).

// Inside the nested for loops, we need to perform a four-way swap between the linked cells. In order to save on some processing, we can store the value of the opposite side of i (opp = n - 1 - i) as that value will be reused many times over.

// Once the nested loops are finished, M has been successfully transformed in-place.

// Time Complexity: O(N^2) where N is the length of each side of the matrix
// Space Complexity: O(1)


class Solution {
    public void rotate(int[][] matrix) {
        // Get the size of the matrix (n x n) and calculate the number of layers (depth).
        int n = matrix.length;
        int depth = n / 2; // The number of concentric layers to process.

        // Loop through each layer, starting from the outermost to the innermost.
        for (int i = 0; i < depth; i++) {
            // Calculate the number of elements in the current layer and the "opposite" index.
            int len = n - 2 * i - 1; // Number of elements in the current row/column of the layer.
            int opp = n - 1 - i;     // The index of the opposite end of the layer.

            // Rotate elements within the current layer.
            for (int j = 0; j < len; j++) {
                // Save the top-left element temporarily.
                int temp = matrix[i][i + j];

                // Perform a four-way rotation:
                // Move bottom-left to top-left.
                matrix[i][i + j] = matrix[opp - j][i];

                // Move bottom-right to bottom-left.
                matrix[opp - j][i] = matrix[opp][opp - j];

                // Move top-right to bottom-right.
                matrix[opp][opp - j] = matrix[i + j][opp];

                // Move the saved top-left value to top-right.
                matrix[i + j][opp] = temp;
            }
        }
    }
}

