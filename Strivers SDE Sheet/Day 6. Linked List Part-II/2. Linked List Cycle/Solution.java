// https://leetcode.com/problems/linked-list-cycle/description/

// ✅ Intuition
// 	•	Use two pointers (slow and fast).
// 	•	slow moves one step; fast moves two steps.
// 	•	If there’s a cycle, slow and fast will eventually meet.
// 	•	If fast reaches the end (null), there’s no cycle.

// ⏰ Time Complexity
// 	•	O(n) → In the worst case, we visit each node once.

// 🪴 Space Complexity
// 	•	O(1) → Constant extra space used (only two pointers).

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * Intuition:
     * - Use two pointers (`slow` and `fast`) to detect a cycle in the linked list.
     * - `slow` moves one step at a time, while `fast` moves two steps.
     * - If there is a cycle, the `fast` and `slow` pointers will eventually meet.
     * - If `fast` reaches the end (null), there is no cycle.
     */

    public boolean hasCycle(ListNode head) {

        // If the list is empty or has only one node, it cannot have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head, slow = head;

        // Traverse the list until fast reaches the end or they meet
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;           // Move slow by 1 step
            fast = fast.next.next;      // Move fast by 2 steps

            if (fast == slow) {         // If they meet, there is a cycle
                return true;
            }
        }

        // If fast reaches the end, no cycle exists
        return false;
    }
}