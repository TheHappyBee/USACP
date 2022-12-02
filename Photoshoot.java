// Arup Guha
// 2/3/2020
// Solution to 2020 January Bronze USACO Problem: Photoshoot

import java.util.*;
import java.io.*;

public class Photoshoot {

    public static void main(String[] args) throws Exception {

        Scanner stdin = new Scanner(new File("photo.in"));
        int n = stdin.nextInt();
        int[] sums = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            sums[i] = stdin.nextInt();

        int[] perm = new int[n];

        // Try each item as the first.
        for (int first = 1; first < sums[0]; first++) {
            perm[0] = first;

            // These are all forced.
            for (int i = 1; i < n; i++)
                perm[i] = sums[i - 1] - perm[i - 1];

            // Good as long as it's a permutation!
            if (isPerm(perm))
                break;
        }

        // Output result.
        PrintWriter out = new PrintWriter(new FileWriter("photo.out"));
        for (int i = 0; i < n - 1; i++)
            out.print(perm[i] + " ");
        out.println(perm[n - 1]);
        out.close();
        stdin.close();
    }

    // Returns true iff perm stores a permutation of 1..perm.length.
    public static boolean isPerm(int[] perm) {

        int n = perm.length;

        // Store how many of each item is here.
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {

            // Screen out things that are out of bounds.
            if (perm[i] < 1 || perm[i] > n)
                return false;

            // Safe to do this.
            freq[perm[i] - 1]++;

            // Oops we have a repeat.
            if (freq[perm[i] - 1] > 1)
                return false;
        }

        // If we get here it has to be a perm.
        return true;
    }
}