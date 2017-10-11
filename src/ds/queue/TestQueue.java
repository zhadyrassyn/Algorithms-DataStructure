package ds.queue;

import util.StdIn;
import util.StdOut;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        while(StdIn.hasNextToken()) {
            String nextToken = StdIn.next();
            queue.enqueue(nextToken);
            StdOut.print(queue.dequeue() + " ");
        }
        StdOut.flush();
    }
}
