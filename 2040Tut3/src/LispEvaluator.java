package src;

import java.util.Stack;

public class LispEvaluator {
    private static double performOp(Stack<Double> operands, char operator) {
        double result = 0.0;

        switch (operator) {
        case '+': // 0.0 + opr1 + opr2 ...
            result = 0.0;
            while (!operands.empty())
                result += operands.pop();
            return result;
        case '-':
            if (operands.size() == 1)
                return -operands.pop(); // -opr1
            result = operands.pop();
            while (!operands.empty())
                result -= operands.pop();
            return result; // opr1 - opr2 - opr3 ...
        case '*':
            result = 1.0;
            while (!operands.empty())
                result *= operands.pop();
            return result;
        default: // floating point division
            if (operands.size() == 1)
                return 1 / operands.pop(); // 1.0/opr1
            result = operands.pop();
            while (!operands.empty())
                result /= operands.pop();
            return result; // opr1 / opr2 / opr3 ...
        } // switch-case: here returns; don't forget to break otherwise!
    } // unspecified behaviour if operator invalid

    public static double evaluate(String expression) {
        Stack<String> allTokens = new Stack<String>(); // outer stack
        String[] tokens = expression.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String currentToken = tokens[i];
            if (currentToken.equals(")")) {
                Stack<Double> operands = new Stack<Double>(); // inner stack
                while ("+-*/".indexOf(allTokens.peek()) == -1) // while operand
                    operands.push(Double.parseDouble(allTokens.pop()));
                char operator = allTokens.pop().charAt(0);
                allTokens.pop(); // remove "("
                allTokens.push("" + performOp(operands, operator));
            } else
                allTokens.push(currentToken);
        }
        return Double.parseDouble(allTokens.pop());
    }

    public static void main(String[] args) {
        System.out.println(evaluate("( + -6.0 ( * 2.0 3.0 4.0 ) )"));
        System.out.println(evaluate("6"));
    }
}