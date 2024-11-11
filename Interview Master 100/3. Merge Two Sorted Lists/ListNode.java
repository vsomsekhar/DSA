// https://leetcode.com/problems/merge-two-sorted-lists/?utm_source=instabyte.io&utm_medium=referral&utm_campaign=interview-master-100

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // If one of the lists is initially null, return the other list
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Dummy node to act as the starting point
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining part of list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // The merged list starts from dummy.next
        return dummy.next;
    }
}


// Algorithm / Intuition
// A more optimised approach would be to merge the given sorted linked lists directly without using any additional space for an intermediate array. We can leverage the property that the given linked lists would be sorted. We employ a pointer based merging strategy where nodes from both linked lists are rearranged to form a single sorted linked list.

// Initializing pointers at the head of the two lists, compare the values of the nodes and the smaller value node becomes the next node in the merged list. The pointers are updated until one list is entirely merged, then attach the remaining nodes of the other list directly to the merged list as they are already sorted.

// Complexity Analysis

// Time Complexity: O(N1+N2) where N1 is the number of nodes in the first linked list and N1 in the second linked list as we traverse both linked lists in a single pass for merging without any additional loops or nested iterations.

// Space Complexity : O(1) as no additional data structures or space is allocated for storing data, only a constant space for pointers to maintain for traversing the linked list.

// Solution using recursion

public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}

