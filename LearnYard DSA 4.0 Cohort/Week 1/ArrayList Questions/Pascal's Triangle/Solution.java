// https://leetcode.com/problems/pascals-triangle/

class Solution {
    /**
     * Intuition:
     * Pascal's Triangle is constructed by adding elements of the previous row.
     * First and last elements of each row are always 1.
     * Each middle element is the sum of the two elements above it.
     */

    public List<List<Integer>> generate(int numRows) {

        // Result list to store all rows of Pascal's Triangle
        List<List<Integer>> answer = new ArrayList<>();
        
        // First row is always [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        answer.add(new ArrayList<>(firstRow));

        int middleElement = 0;

        // Generate rows from row 1 to numRows - 1
        for (int i = 1; i < numRows; i++) {

            // Create a new row and add the first element (always 1)
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            // Compute middle elements based on the previous row
            for (int j = 1; j <= middleElement; j++) {
                // Sum of two elements directly above the current position
                currentRow.add(answer.get(i - 1).get(j) + answer.get(i - 1).get(j - 1));
            }

            middleElement++;
            // Last element is always 1
            currentRow.add(1);

            // Add current row to the answer
            answer.add(new ArrayList<>(currentRow));
        }

        return answer;
    }
}

// ✅ Intuition
// 	•	Pascal’s Triangle is constructed based on the sum of elements from the previous row.
// 	•	First and last elements of each row are always 1.
// 	•	Each middle element is calculated using currentRow[j] = previousRow[j - 1] + previousRow[j].

// ⏰ Time Complexity
// 	•	O(numRows²) → Each row calculation depends on the previous row, leading to a nested loop with increasing iterations.

// 🪴 Space Complexity
// 	•	O(numRows²) → We store numRows rows, each containing up to numRows elements.
