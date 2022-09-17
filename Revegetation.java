import java.util.*;
import java.io.*;

public class Revegetation {

    public static void main(String[] args) throws Exception {

        // Get positions.
        Scanner stdin = new Scanner(new File("revegetate.in"));
        int numPastures = stdin.nextInt();
        int numCows = stdin.nextInt();

        // Store graph of differences.
        ArrayList[] graph = new ArrayList[numPastures];
        for (int i = 0; i < numPastures; i++)
            graph[i] = new ArrayList<Integer>();
        for (int i = 0; i < numCows; i++) {
            int v1 = stdin.nextInt() - 1;
            int v2 = stdin.nextInt() - 1;
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // Do it!
        int[] odom = new int[numPastures];
        go(odom, graph, 0);

        // Output results.
        PrintWriter out = new PrintWriter(new FileWriter("revegetate.out"));
        for (int i = 0; i < numPastures; i++)
            out.print(odom[i]);
        out.println();
        out.close();
        stdin.close();
    }

    public static boolean go(int[] odom, ArrayList[] graph, int k) {

        if (k == odom.length)
            return true;

        // Try placing grass i in slot k.
        for (int i = 1; i <= 4; i++) {

            // See if this contradicts a previous placement.
            boolean ok = true;
            for (Integer x : (ArrayList<Integer>) graph[k]) {
                if (odom[x] == i) {
                    ok = false;
                    break;
                }
            }

            // Skip if not okay.
            if (!ok)
                continue;

            // Place and go.
            odom[k] = i;
            boolean tmp = go(odom, graph, k + 1);
            if (tmp)
                return true;
            odom[k] = 0;
        }

        return false;
    }

}