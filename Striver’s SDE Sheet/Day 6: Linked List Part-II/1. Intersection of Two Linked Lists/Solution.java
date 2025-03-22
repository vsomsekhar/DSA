// https://leetcode.com/problems/intersection-of-two-linked-lists/description/

// ✅ Intuition
// 	•	Use two pointers (dummy1 and dummy2) to traverse both lists.
// 	•	If a pointer reaches the end, switch to the head of the other list.
// 	•	If there’s an intersection, they will meet at the intersection point.
// 	•	If there’s no intersection, both will become null at the same time.

// ⏰ Time Complexity
// 	•	O(m + n) → m and n are the lengths of the two lists.

// 🪴 Space Complexity
// 	•	O(1) → Constant extra space used (only two pointers).

/**
 * Definition for singly-linked list.
 * public class ListNode {
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
     * - Use two pointers (`dummy1` and `dummy2`) to find the intersection point.
     * - Traverse both lists simultaneously.
     * - When a pointer reaches the end of a list, redirect it to the head of the other list.
     * - If there's an intersection, both pointers will meet at the intersection node.
     * - If there's no intersection, both pointers will become null simultaneously.
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode dummy1 = headA;
        ListNode dummy2 = headB;

        // Traverse both lists; when one pointer reaches the end, switch to the other list
        while (dummy1 != dummy2) {
            // If dummy1 reaches the end, start at headB; otherwise, move to the next node
            dummy1 = (dummy1 == null) ? headB : dummy1.next;
            // If dummy2 reaches the end, start at headA; otherwise, move to the next node
            dummy2 = (dummy2 == null) ? headA : dummy2.next;
        }

        // Either both pointers meet at the intersection or both are null (no intersection)
        return dummy1;
    }
}