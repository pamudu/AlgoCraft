package org.example.stack;

import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        System.out.println(getResult("18-(7+(2-4))"));
    }

    private static int getResult(String expression){
        int result = 0;
        Stack<Integer> numberStack = new Stack<>();
        String [] elements = expression.split("");

        int currentNumber = 0;
        int sign = 1;
        for(String element : elements){
            switch (element) {
                case "-" -> {
                    if (currentNumber != 0) {
                        result += currentNumber * sign;
                        currentNumber = 0;
                    }
                    sign = -1;
                }
                case "+" -> {
                    if (currentNumber != 0) {
                        result += currentNumber * sign;
                        currentNumber = 0;
                    }
                    sign = 1;
                }
                case "(" -> {
                    numberStack.push(result);
                    numberStack.push(sign);
                    sign = 1;
                    result = 0;
                }
                case ")" -> {
                    result *= numberStack.pop();
                    result += numberStack.pop();
                }
                default -> currentNumber = currentNumber * 10 + Integer.parseInt(element);
            }
        }
        result += currentNumber;

        return result;
    }
}
