package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by daniyar on 10/10/17.
 */
public final class StdIn {

    private static BufferedReader br;
    private static StringTokenizer st;

    private static InputStream inputStream = System.in;

    static {
        br = new BufferedReader(new InputStreamReader(inputStream));
    }


    private StdIn() {}

    public static boolean hasNextToken() {
        if(st == null) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.hasMoreTokens();
    }

    public static String next() {
        while(st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public static String nextLine() throws IOException {
        return br.readLine();
    }

    public static int nextInt() {
        return Integer.parseInt(next());
    }

    public static long nextLong() {
        return Long.parseLong(next());
    }

    public static double nextDouble() {
        return Double.parseDouble(next());
    }

}
