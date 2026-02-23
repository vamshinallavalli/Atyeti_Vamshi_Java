package StackOutputBasedQuestions;

import java.util.Scanner;
import java.util.Stack;

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) return false;

                    char top = stack.pop();

                    if ((ch == ')' && top != '(') ||
                            (ch == '}' && top != '{') ||
                            (ch == ']' && top != '[')) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

        public class ValidParenthesis {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter parentheses string: ");
            String s = sc.nextLine();

            Solution sol = new Solution();
            boolean result = sol.isValid(s);

            System.out.println("Is Valid Parentheses? " + result);
        }
    }
