// https://leetcode.com/problems/middle-of-the-linked-list/description/

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
     * - Use two pointers (`slow` and `fast`) to find the middle of the list.
     * - `slow` moves one step at a time.
     * - `fast` moves two steps at a time.
     * - When `fast` reaches the end, `slow` will be at the middle.
     */

    public ListNode middleNode(ListNode head) {

        // Two pointers: slow moves 1 step, fast moves 2 steps
        ListNode fast = head, slow = head;

        // Fast pointer moves until it reaches the end of the list
        while (fast != null && fast.next != null) {
            // Slow pointer moves one step
            slow = slow.next;
            // Fast pointer moves two steps
            fast = fast.next.next;
        }

        // Slow pointer will now be at the middle node
        return slow;
    }
}

// ✅ Intuition
// 	•	slow moves one node at a time.
// 	•	fast moves two nodes at a time.
// 	•	When fast reaches the end (or becomes null), slow will be at the middle node.

// ⏰ Time Complexity
// 	•	O(n) → We visit each node at most once.

// 🪴 Space Complexity
// 	•	O(1) → Constant extra space used (only two pointers).