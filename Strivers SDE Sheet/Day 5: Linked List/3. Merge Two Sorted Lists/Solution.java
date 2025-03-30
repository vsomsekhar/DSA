// https://leetcode.com/problems/merge-two-sorted-lists/solutions/9906/just-can-t-image-why-there-are-so-many-recursion-enthusiast-mine-is-a-neat-iterative-little-ones/

// ✅ Intuition
// 	•	Create a dummy node to simplify merging.
// 	•	Compare nodes from both lists.
// 	•	Link the smaller node to the result list.
// 	•	Continue until one list is empty.
// 	•	Attach the remaining nodes from the non-empty list.

// ⏰ Time Complexity
// 	•	O(n + m) → We visit each node from both lists once, where n and m are the lengths of list1 and list2.

// 🪴 Space Complexity
// 	•	O(1) → Constant extra space used (only a few pointers).

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
     * - Use a dummy node to simplify the merging process.
     * - Compare the values of `list1` and `list2`.
     * - Link the smaller node to the result list.
     * - Move the pointer of the list with the smaller node forward.
     * - If one list is exhausted, link the remaining nodes from the other list.
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // If either list is empty, return the other list
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Dummy node to simplify handling of the head node
        ListNode head = new ListNode(-1);
        ListNode currentLink = head;

        // Compare values from both lists and merge in sorted order
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // Take node from list1
                currentLink.next = list1;
                list1 = list1.next;
            } else {
                // Take node from list2
                currentLink.next = list2;
                list2 = list2.next;
            }
            // Move to the next node in the result list
            currentLink = currentLink.next;
        }
        
        // If any nodes remain in either list, link them directly
        if (list1 != null) currentLink.next = list1;
        if (list2 != null) currentLink.next = list2;

        // The merged list starts at head.next
        return head.next;
    }
}