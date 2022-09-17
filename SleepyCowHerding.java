import java.util.*;
import java.io.*;

public class SleepyCowHerding {

    public static void main(String[] args) throws Exception {

        // Get positions.
        Scanner stdin = new Scanner(new File("herding.in"));
        int[] list = new int[3];
        for (int i = 0; i < 3; i++)
            list[i] = stdin.nextInt();
        Arrays.sort(list);

        // Output results.
        PrintWriter out = new PrintWriter(new FileWriter("herding.out"));
        out.println(min(list));
        out.println(max(list));
        out.close();
        stdin.close();
    }

    // Pre-condition: list is sorted and of length 3.
    // Post-conditions: returns the minimum number of jumps to get consecutive.
    public static int min(int[] list) {

        // Already consecutive.
        if (list[2] - list[0] == 2)
            return 0;

        // Gap of 2 for other cow to jump into.
        if (list[1] - list[0] == 2 || list[2] - list[1] == 2)
            return 1;

        // We can always do it in two.
        return 2;
    }

    // Pre-condition: list is sorted and of length 3.
    // Post-conditions: returns the maximum number of jumps to get consecutive.
    public static int max(int[] list) {

        // This is easy; just jump into larger of the two gaps and leap frog...
        return Math.max(list[1] - list[0] - 1, list[2] - list[1] - 1);
    }
}