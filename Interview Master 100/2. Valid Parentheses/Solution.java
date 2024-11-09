// https://leetcode.com/problems/valid-parentheses/submissions/1447470649/?utm_source=instabyte.io&utm_medium=referral&utm_campaign=interview-master-100

class Solution {
    public boolean isValid(String s) {

        int stringLength = s.length();
        Stack<Character> stack = new Stack<>();

        if (stringLength < 2) 
            return false;
        
        for (int i = 0; i < stringLength; i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != '(')
                    return false;
            }
            else if (s.charAt(i) == '}') {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != '{')
                    return false;
            }
            else if (s.charAt(i) == ']') {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != '[')
                    return false;
            }
            else
                stack.push(s.charAt(i));
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}

// Intuition
// The problem requires us to determine if the given string of brackets is valid or not. We can use a stack data structure to keep track of opening brackets encountered and check if they match with the corresponding closing brackets.

// Approach
// Here is the step-by-step approach of the algorithm:

// Initialize an empty stack.

// Traverse the input string character by character.

// If the current character is an opening bracket (i.e., '(', '{', '['), push it onto the stack.

// If the current character is a closing bracket (i.e., ')', '}', ']'), check if the stack is empty. If it is empty, return false, because the closing bracket does not have a corresponding opening bracket. Otherwise, pop the top element from the stack and check if it matches the current closing bracket. If it does not match, return false, because the brackets are not valid.

// After traversing the entire input string, if the stack is empty, return true, because all opening brackets have been matched with their corresponding closing brackets. Otherwise, return false, because some opening brackets have not been matched with their corresponding closing brackets.

// Complexity
// Time complexity:
// The time complexity of the solution is O(n), where n is the length of the input string. This is because we traverse the string once and perform constant time operations for each character.

// Space complexity:
// The space complexity of the solution is O(n), where n is the length of the input string. This is because the worst-case scenario is when all opening brackets are present in the string and the stack will have to store them all.


class Solution {
    public boolean isValid(String s) {
        // Create an empty stack to keep track of opening brackets
        Stack<Character> stack = new Stack<Character>();
        
        // Loop through every character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else { // If the character is a closing bracket
                // If the stack is empty, there is no matching opening bracket, so return false
                if (stack.isEmpty()) {
                    return false;
                }
                // Otherwise, get the top of the stack and check if it's the matching opening bracket
                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    // If it is, pop the opening bracket from the stack
                    stack.pop();
                } else { // Otherwise, the brackets don't match, so return false
                    return false;
                }
            }
        }
        // If the stack is empty, all opening brackets have been closed, so return true
        // Otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }
}

// JAVA solution without using stack

public class Solution {
    public static boolean isValid(String s) {
        while (true) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            } else if (s.contains("{}")) {
                s = s.replace("{}", "");
            } else if (s.contains("[]")) {
                s = s.replace("[]", "");
            } else {
                // If the string becomes empty, it indicates all brackets are matched.
                return s.isEmpty();
            }
        }
    }
}