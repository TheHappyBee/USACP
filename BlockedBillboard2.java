import java.util.*;
import java.io.*;

public class BlockedBillboard2 {

    final public static int OFFSET = 1000;
    final public static int MAX = 2001;

    public static void main(String[] args) throws Exception {

        // Read the data.
        Scanner stdin = new Scanner(new File("billboard.in"));

        boolean[] iter = { true, false };
        boolean[][] need = new boolean[MAX][MAX];

        // Go through data.
        for (int i = 0; i < 2; i++) {

            // Read the coordinates.
            int x1 = stdin.nextInt() + OFFSET;
            int y1 = stdin.nextInt() + OFFSET;
            int x2 = stdin.nextInt() + OFFSET;
            int y2 = stdin.nextInt() + OFFSET;

            // Set these squares to the appropriate value.
            for (int x = x1; x < x2; x++)
                for (int y = y1; y < y2; y++)
                    need[x][y] = iter[i];
        }

        boolean zero = true;

        // Find min and max of what needs to be covered.
        int minX = MAX, maxX = -1, minY = MAX, maxY = -1;
        for (int x = 0; x < MAX; x++) {
            for (int y = 0; y < MAX; y++) {
                if (need[x][y]) {
                    zero = false;
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        // Either we don't need to cover anything, or use are mins and maxs.
        int res = zero ? 0 : (maxX - minX + 1) * (maxY - minY + 1);

        // Ta da!
        PrintWriter out = new PrintWriter(new FileWriter("billboard.out"));
        out.println(res);
        out.close();
        stdin.close();
    }
}