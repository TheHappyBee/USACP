import java.util.*;
import java.io.*;

public class BackAndForth {

    public static ArrayList<Integer> list1;
    public static ArrayList<Integer> list2;
    public static int milk;
    public static HashSet<Integer> possible;

    public static void main(String[] args) throws Exception {

        Scanner stdin = new Scanner(new File("backforth.in"));
        possible = new HashSet<Integer>();

        // Read in the lists.
        list1 = new ArrayList<Integer>();
        list2 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            list1.add(stdin.nextInt());
        for (int i = 0; i < 10; i++)
            list2.add(stdin.nextInt());
        milk = 1000;

        // Run the recursion.
        go(0);

        // Print out the result.
        PrintWriter out = new PrintWriter(new FileWriter("backforth.out"));
        out.print(possible.size());
        out.close();
        stdin.close();
    }

    public static void go(int day) {

        // Done!
        if (day == 4) {
            possible.add(milk);
            return;
        }

        // Going barn 1 to barn 2.
        if (day % 2 == 0) {

            // Transfer bucket i from barn 1 to barn 2.
            for (int i = 0; i < list1.size(); i++) {

                // This is the transfer.
                milk -= list1.get(i);
                int tmp = list1.remove(i);
                list2.add(tmp);

                // Recurse.
                go(day + 1);

                // Have to undo so next edit is accurate.
                tmp = list2.remove(list2.size() - 1);
                list1.add(i, tmp);
                milk += list1.get(i);
            }
        }

        // Going barn 2 to barn 1.
        else {

            // Transfer bucket i from barn 2 to barn 1.
            for (int i = 0; i < list2.size(); i++) {

                // This is the transfer.
                milk += list2.get(i);
                int tmp = list2.remove(i);
                list1.add(tmp);

                // Recurse.
                go(day + 1);

                // Undo our changes.
                tmp = list1.remove(list1.size() - 1);
                list2.add(i, tmp);
                milk -= list2.get(i);
            }
        }
    }
}