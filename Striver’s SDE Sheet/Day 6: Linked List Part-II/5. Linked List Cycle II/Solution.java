// https://leetcode.com/problems/linked-list-cycle-ii/description/

// ✅ Intuition
// 	1.	Use two pointers (slow and fast).
// 	2.	If a cycle exists, slow and fast will meet inside the cycle.
// 	3.	Reset slow to the head and move both one step at a time.
// 	4.	The meeting point is the starting node of the cycle.

// ⏰ Time Complexity
// 	•	O(n) → In the worst case, we visit each node at most twice.

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
     * - If a cycle exists, `slow` and `fast` will eventually meet.
     * - Once they meet, reset `slow` to the head and keep `fast` at the meeting point.
     * - Move both pointers one step at a time until they meet again — the meeting point is the start of the cycle.
     */

    public ListNode detectCycle(ListNode head) {

        // If the list is empty or has only one node, no cycle is possible
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;

        // Step 1: Detect if a cycle exists
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;           // Move slow by 1 step
            fast = fast.next.next;      // Move fast by 2 steps

            if (slow == fast) {         // If they meet, a cycle exists
                // Step 2: Find the starting node of the cycle
                slow = head;            // Reset slow to head
                while (slow != fast) {  // Move both pointers at the same pace
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;            // Meeting point is the start of the cycle
            }
        }

        return null; // No cycle found
    }
}