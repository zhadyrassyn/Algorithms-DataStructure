package ds.stack;

import util.StdIn;
import util.StdOut;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while(StdIn.hasNextToken()) {
            String nextToken = StdIn.next();
            stack.push(nextToken);
        }

        while(!stack.isEmpty()) {
            StdOut.println(stack.pop());
        }
        StdOut.flush();
    }
}
