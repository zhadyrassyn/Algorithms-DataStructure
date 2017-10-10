package ds.bag;

import util.StdIn;
import util.StdOut;

public class TestBag {
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        while(StdIn.hasNextToken()) {
            bag.add(StdIn.next());
        }

        StdOut.println("Size: " + bag.size());
        for(String s: bag) {
            StdOut.println(s);
        }
        StdOut.flush();

    }
}
