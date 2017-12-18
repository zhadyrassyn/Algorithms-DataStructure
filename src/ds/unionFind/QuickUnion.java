package ds.unionFind;

import util.StdIn;
import util.StdOut;

public class QuickUnion implements UF{

    private int[] id;
    private int count;

    public QuickUnion(int N) {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }

        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.nextInt();
        QuickUnion qu = new QuickUnion(N);
        for(int i = 0; i < qu.count(); i++) {
            int p = Integer.parseInt(StdIn.next());
            int q = Integer.parseInt(StdIn.next());
            if(qu.connected(p, q)) {
                System.out.printf("Already connected: (%d, %d)\n", p, q);
            } else {
                qu.union(p, q);
                System.out.println("Connected");
            }
        }

        StdOut.flush();
    }
}
