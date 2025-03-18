// https://leetcode.com/problems/reverse-linked-list/description/

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
     * To reverse a linked list:
     * - Start with a new head as null.
     * - Keep redirecting the `next` pointer of each node to point to the previous node.
     * - Update head and continue until the original list is fully reversed.
     */

    public ListNode reverseList(ListNode head) {

        // Pointer to the new head of the reversed list (starts as null)
        ListNode newHead = null;

        // Iterate through the original list
        while (head != null) {
            // Temporarily store the next node
            ListNode temp = head.next;

            // Reverse the link: point current node's next to newHead
            head.next = newHead;

            // Move newHead to current node
            newHead = head;

            // Move head to the next node in the original list
            head = temp;
        }

        // newHead will be the head of the reversed list
        return newHead;
    }
}

// ✅ Intuition
// 	•	We reverse the linked list by redirecting the next pointers.
// 	•	Maintain a newHead to track the head of the reversed list.
// 	•	At each step:
// 	•	Save the next node.
// 	•	Reverse the pointer.
// 	•	Move the head and newHead forward.

// ⏰ Time Complexity
// 	•	O(n) → We visit each node exactly once.

// 🪴 Space Complexity
// 	•	O(1) → Constant extra space used (only a few pointers).