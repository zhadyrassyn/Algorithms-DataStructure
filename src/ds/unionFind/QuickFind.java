package ds.unionFind;

import util.StdIn;
import util.StdOut;

import java.util.Arrays;

public class QuickFind implements UF{
    private int[] id;
    private int count;

    public QuickFind(int N) {
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
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID) return;

        for(int i = 0; i < id.length; i++) {
            if(id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.nextInt();
        QuickFind qf = new QuickFind(N);
        for(int i = 0; i < qf.count(); i++) {
            int p = Integer.parseInt(StdIn.next());
            int q = Integer.parseInt(StdIn.next());
            if(qf.connected(p, q)) {
                System.out.printf("Already connected: (%d, %d)\n", p, q);
            } else {
                qf.union(p, q);
                System.out.println("Connected");
            }
        }

        StdOut.flush();
    }
}
