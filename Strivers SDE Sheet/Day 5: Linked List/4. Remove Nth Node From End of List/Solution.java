// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

// ✅ Intuition
// 	•	Move the fast pointer n steps ahead.
// 	•	Then move both fast and slow pointers until fast reaches the last node.
// 	•	slow will be at the node before the target node.
// 	•	Skip the nth node by updating the next pointer.

// ⏰ Time Complexity
// 	•	O(n) → We visit each node at most once.

// 🪴 Space Complexity
// 	•	O(1) → Constant extra space used (only two pointers).

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
     * - Use two pointers (`fast` and `slow`) to find the nth node from the end.
     * - Move `fast` pointer `n` steps ahead.
     * - Then move both pointers one step at a time until `fast` reaches the end.
     * - `slow` will be at the node before the nth node.
     * - Remove the nth node by updating the `next` pointer of `slow`.
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        // Move fast pointer n steps ahead
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // If fast is null, it means the node to remove is the head itself
        if (fast == null) return head.next;

        // Move both fast and slow until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the nth node from the end
        slow.next = slow.next.next;

        return head;
    }
}