// https://leetcode.com/problems/add-two-numbers/

// ✅ Intuition
// 	•	Start adding digits from the head (least significant digit).
// 	•	Keep track of the carry.
// 	•	If one list is shorter, treat missing digits as 0.
// 	•	If carry remains after the last digit, create a new node for it.

// ⏰ Time Complexity
// 	•	O(max(n, m)) → n and m are the lengths of l1 and l2 respectively.

// 🪴 Space Complexity
// 	•	O(max(n, m)) → The result list size is at most one digit longer than the longer input list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    /**
     * Intuition:
     * - Add corresponding digits of two linked lists representing numbers.
     * - Start from the least significant digit (head of the list).
     * - Keep track of the carry from the sum.
     * - If one list is shorter, treat missing digits as zero.
     * - If there's a carry left after the last digit, create a new node for it.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to simplify handling the result list
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        // Process both lists until they are fully traversed or carry remains
        while (l1 != null || l2 != null || carry != 0) {
            // Get the current digits (if null, use 0)
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            // Calculate sum and carry
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            // Create a new node for the current digit
            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            // Move to the next node in both lists (if available)
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        // Return the next of dummy head (actual head of result list)
        return dummyHead.next;
    }
}