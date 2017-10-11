package util;


import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by daniyar on 10/10/17.
 */
public final class StdOut {
    private static PrintWriter pw;

    private static OutputStream outputStream = System.out;
    static {
        pw = new PrintWriter(new OutputStreamWriter(outputStream));
    }

    public static void println() {
        pw.println();
    }

    public static void println(Object o) {
        pw.println(o.toString());
    }

    public static void print(Object o) {
        pw.print(o);
    }
    public static void flush() {
        pw.flush();
    }


}
