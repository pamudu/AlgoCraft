package org.example.stack;

import java.util.Map;
import java.util.Stack;
/*
Given a string representing an expression of parentheses containing the characters '(', ')', '{', '}', '[', ']'
determine if the expression forms a valid sequence of parentheses.
A sequence of parentheses is valid if every opening parenthesis has a corresponding closing parenthesis,
and no closing parenthesis appears before its matching opening parenthesis.

Example 1:
    Input: s= "([]{})"
    Output: True

Example 2:
    Input: s="([]{)}"
    Output: False
    Explanation: The '(parenthesis is closed before its nested ' ( parenthesis is closed.
*/
public class ValidParenthesisExpression {
    public static void main(String[] args) {
        String input1 = "([]{})";
        String input2 = "([]{)}";
        System.out.println(isValidParenthesisExpression(input2));
    }
    public static final Map<Character, Character> MATCHING = Map.of('(',')','{','}','[','}');
    public static boolean isValidParenthesisExpression(String expression){
        if(expression == null || expression.isEmpty() || expression.length() % 2 != 0){
            return false;
        }

        Stack<Character> parenthesisStack = new Stack<>();

        for(char parenthesis : expression.toCharArray()){
            if(MATCHING.containsKey(parenthesis)){
                parenthesisStack.push(parenthesis);
            }else{
                if(parenthesisStack.isEmpty()){
                    return false;
                }
                if(MATCHING.get(parenthesisStack.pop()) != parenthesis){
                    return false;
                }

            }
        }
        return parenthesisStack.isEmpty();
    }


}
