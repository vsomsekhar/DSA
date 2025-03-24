// https://leetcode.com/problems/palindrome-linked-list/description/

// ✅ Intuition
// 	1.	Find the middle of the list using the slow and fast pointer technique.
// 	2.	Reverse the second half of the list.
// 	3.	Compare the first half and the reversed second half.
// 	4.	If all values match, it’s a palindrome; otherwise, it’s not.

// ⸻

// ⏰ Time Complexity
// 	•	O(n) → Finding the middle, reversing, and comparing each element are all linear operations.

// ⸻

// 🪴 Space Complexity
// 	•	O(1) → Constant extra space used (reversing is done in place).

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
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        
        ListNode slow = head, fast = head;
        
        // Find the middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the list
        slow = reverse(slow);
        fast = head;
        
        // Compare both halves
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}