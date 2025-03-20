// https://leetcode.com/problems/delete-node-in-a-linked-list/

// https://leetcode.com/problems/delete-node-in-a-linked-list/solutions/5113147/detailed-explanation-extremely-simple-1-2-liner-o-1-time-and-space-complexity/

// 🤔 Intuition
// We know that previous node pointer to given node. What if we change given node value to next nodes and point next to next.next. It's essentially changing current node to next and deleting next.

// 🧠 Approach
// To delete the given node, we copy the value of the next node to the current node and adjust the next pointer to skip the next node.

// Copy the value of the next node to the current node.
// Adjust the next pointer to skip the next node.

// Note: We are not actually removing/deleting given node, as question might imply. To actually delete the node, we need to change the reference of the previous node's next pointer to skip over the given node. However, we do not have access to the previous node.

// 📒 Complexity
// ⏰ Time complexity: O(1), as we're only modifying the current node
// 🧺Space complexity: O(1), no extra space is used.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}