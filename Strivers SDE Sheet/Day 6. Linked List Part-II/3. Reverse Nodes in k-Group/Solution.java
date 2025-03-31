// https://leetcode.com/problems/reverse-nodes-in-k-group/description/

// ✅ Intuition
// 	1.	Identify groups of k nodes.
// 	2.	Reverse each group of k nodes while keeping track of their connections.
// 	3.	If the remaining nodes are fewer than k, leave them as they are.
// 	4.	Maintain pointers to track and update the linked list correctly.

// ⸻

// ⏰ Time Complexity
// 	•	O(n) → We traverse the list once and reverse each node exactly once.

// ⸻

// 🪴 Space Complexity
// 	•	O(1) → We only use a few extra pointers (constant space), modifying the list in place.

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
     * - We want to reverse every `k`-sized group of nodes in the linked list.
     * - Use a dummy node to handle edge cases and track the previous group's end.
     * - For each group of `k` nodes:
     *   - Identify the `kthNode` (last node in the group).
     *   - Reverse the nodes in that group.
     *   - Reconnect the reversed segment with the next part of the list.
     *   - Move to the next group and repeat.
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null || k == 1) return head; // Edge case: No need to reverse

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Find the k-th node from prevGroupEnd
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                kthNode = kthNode.next;
                if (kthNode == null) return dummy.next; // If fewer than k nodes remain, return
            }

            ListNode nextGroupStart = kthNode.next; // The next group's first node
            ListNode reversedHead = reverse(prevGroupEnd.next, kthNode);
            ListNode prevGroupStart = prevGroupEnd.next; // Original head of this segment

            // Connect the reversed group with previous and next parts
            prevGroupEnd.next = reversedHead;
            prevGroupStart.next = nextGroupStart;

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = prevGroupStart;
        }
    }

    /**
     * Reverses the linked list segment from head to tail (inclusive).
     * @param head - The start node of the segment to reverse.
     * @param tail - The last node of the segment to reverse.
     * @return New head after reversal (previously tail).
     */
    public ListNode reverse(ListNode head, ListNode tail) {
        
        ListNode prev = null, curr = head, next = null;
        ListNode stop = tail.next; // Marks where to stop reversing

        while (curr != stop) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return tail; // New head of reversed section
    }
}