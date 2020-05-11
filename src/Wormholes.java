import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Wormholes {
    static int n;
    static int[] x, y;
    static int[] partner;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        x = new int[n+1];
        y = new int[n+1];
        partner = new int[n];
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
    }
    public static void pairUp() {

    }
}
