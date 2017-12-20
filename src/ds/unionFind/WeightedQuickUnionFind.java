package ds.unionFind;

import util.StdIn;
import util.StdOut;

public class WeightedQuickUnionFind implements UF{
    private int[] id; //parent link
    private int[] sz; //size of components for root
    private int count;

    public WeightedQuickUnionFind(int N) {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }

        sz = new int[N];
        for(int i = 0; i < N; i++) {
            sz[i] = 1;
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
        int root = p;
        while(root != id[p]) {
            root = id[p];
        }

        while(p != root) {
            int newp = id[p];
            id[p] = root;
            p = newp;
        }
        return root;
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if(i == j) {
            return;
        }

        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.nextInt();
        WeightedQuickUnionFind qu = new WeightedQuickUnionFind(N);
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
