package applications.ds.stack;

import ds.stack.Stack;
import util.StdIn;
import util.StdOut;

public class ArithmeticExpression {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> values = new Stack<>();
        while(StdIn.hasNextToken()) {
            String s = StdIn.next();
            switch (s) {
                case "(":
                    break;
                case "+":
                    ops.push(s);
                    break;
                case "-":
                    ops.push(s);
                    break;
                case "/":
                    ops.push(s);
                    break;
                case "*":
                    ops.push(s);
                    break;
                case "sqrt":
                    ops.push(s);
                    break;
                case ")":
                    String op = ops.pop();
                    double v = values.pop();
                    switch (op) {
                        case "+":
                            v = values.pop() + v;
                            break;
                        case "-":
                            v = values.pop() - v;
                            break;
                        case "*":
                            v = values.pop() * v;
                            break;
                        case "/":
                            v = values.pop() / v;
                            break;
                        case "sqrt":
                            v = Math.sqrt(v);
                            break;
                    }
                    values.push(v);
                    break;
                default:
                    values.push(Double.parseDouble(s));
                    break;
            }

        }
        StdOut.print(values.pop());
        StdOut.flush();
    }
}
