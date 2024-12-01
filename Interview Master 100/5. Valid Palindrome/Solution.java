// https://leetcode.com/problems/valid-palindrome/submissions/1466323831/?utm_source=instabyte.io&utm_medium=referral&utm_campaign=interview-master-100

public class Solution {
    public boolean isPalindrome(String s) {
        int start = 0; 
        int end = s.length() - 1;
        while(start <= end) {
            while(start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while(start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if(start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// My thoughts on this problem is that the interviewers are not looking at a solution using Regex, it would be too trivial, plus it would take O(n) space to save the new trimmed string. I would just use plain two points to traverse the string and compare them ignore case. It is O(n) time and O(1) space guaranteed and no expensive string concatenation is required.

