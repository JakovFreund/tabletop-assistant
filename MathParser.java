import java.util.Stack;

public class MathParser {

    public static void main(String[] args) {
        /*
        int upcast = 2;
        String formula = "(1+{upcast})*3/6*2";
        
        // Replace the variable
        formula = formula.replace("{upcast}", Integer.toString(upcast));
        
        // Evaluate the expression
        try {
            int result = evaluateExpression(formula);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    // Evaluate expression with integers and basic operations (+, -, *, /, parentheses)
    public static int evaluateExpression(String expression) throws Exception {
        return evaluatePostfix(infixToPostfix(expression));
    }

    // Convert infix expression to postfix expression (RPN - Reverse Polish Notation)
    private static String infixToPostfix(String expression) throws Exception {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Skip spaces
            if (c == ' ')
                continue;

            // If the character is a digit, add it to output
            if (Character.isDigit(c)) {
                result.append(c);
                // Handle multi-digit numbers
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    result.append(expression.charAt(++i));
                }
                result.append(' '); // Add space as a separator for numbers
            }
            // If the character is '(', push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is ')', pop and add to output from the stack until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop()).append(' ');
                stack.pop(); // Remove '(' from the stack
            }
            // If the character is an operator, handle operator precedence
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(' ');
        }

        return result.toString();
    }

    // Function to evaluate a postfix expression
    private static int evaluatePostfix(String postfix) throws Exception {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // Skip spaces
            if (c == ' ')
                continue;

            // If the character is a digit, push it to the stack
            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < postfix.length())
                        c = postfix.charAt(i);
                    else
                        break;
                }
                i--; // Step back since the loop went one step too far
                stack.push(num);
            }
            // If the character is an operator, pop two elements from the stack and apply the operator
            else if (isOperator(c)) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                stack.push(applyOperator(c, val1, val2));
            }
        }

        return stack.pop();
    }

    // Check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Define operator precedence
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Apply an operator to two operands
    private static int applyOperator(char operator, int a, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new UnsupportedOperationException("Unknown operator: " + operator);
        }
    }
}
