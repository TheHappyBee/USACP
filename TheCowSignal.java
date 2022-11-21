import java.io.*;
import java.util.*;

public class TheCowSignal {

    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < r; i++) {
            // get the next row to generate k copies of
            String currRow = br.readLine();
            
            // we will generate the same row K times
            for(int internalRow = 0; internalRow < k; internalRow++) {
                // loop over each character...
                for(int j = 0; j < c; j++) {
                    // and print it k times
                    for(int a = 0; a < k; a++) {
                        pw.print(currRow.charAt(j));
                    }
                }
                // we need to print a new line to indicate that we need to go to the next row
                pw.println();
            }
        }
        
        pw.close();
    }
}