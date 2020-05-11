/*
 ID: dioxric1
 LANG: JAVA
 TASK: skidesign
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
public class skidesign {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("skidesign.in"));
        int n = in.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }
        int ans = solve(heights);
        PrintWriter pw = new PrintWriter(new File("skidesign.out"));
        pw.println(ans);
        pw.close();
    }
    public static int solve(int[] heights) {
        int bestcost = Integer.MAX_VALUE;
        for (int i = 0; i <= 83; i++) {
            int min = i;
            int max = min+17;
            int localcost = 0;
            for (int height: heights) {
                int change = 0;
                if (height < min)
                    change = min-height;
                else if (height > max)
                    change = height-max;
                localcost += change*change;
            }
            bestcost = Math.min(localcost, bestcost);
        }
        return bestcost;
    }
}
