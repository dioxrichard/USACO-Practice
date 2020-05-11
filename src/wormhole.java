/*
 ID: dioxric1
 LANG: JAVA
 TASK: wormhole
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class wormhole {
    static int n;
    static int[] x, y;
    static int[] partner;
    static int[] next_on_right;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        x = new int[n+1];
        y = new int[n+1];
        partner = new int[n+1];
        next_on_right = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (y[i] == y[j] && x[i] < x[j]) {
                    if (next_on_right[i] == 0 || x[j] - x[i] < x[next_on_right[i]]-x[i])
                        next_on_right[i] = j;
                }
            }
        }
        solve();
        PrintWriter pw = new PrintWriter(new File("wormhole.out"));
        pw.println(count);
        pw.close();
    }
    public static void solve() {
        int i = 0;
        for (i = 1; i <= n; i++) {
            if (partner[i] == 0)
                break;
        }
        if (i > n) {
            if (hasCycle()) {
                count++;
            }
        }
        for (int j = i+1; j <= n; j++) {
            if (partner[j] == 0) {
                partner[j] = i;
                partner[i] = j;
                solve();
                partner[j] = 0;
                partner[i] = 0;
            }
        }
    }
    public static boolean hasCycle() {
        for (int start = 1; start <= n; start++) {
            int pos = start;
            int count = 0;
            while (next_on_right[pos] != 0) {
                pos = next_on_right[pos];
                pos = partner[pos];
                count++;
                if (count > n) {
                    return true;
                }
            }
        }
        return false;
    }
}
