/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Liu Home Desktop
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //goal comapare each diamond with the other to see if they are able to fit
        FileReader fileReader = new FileReader(
                "diamond.in"
        );
        
        BufferedReader reader = new BufferedReader(fileReader);
        
        String[] s = reader.readLine().split(" ");
        int ANS =0;
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] diamonds = new int[N];
        for (int n=0; n<N; n++) {
            diamonds[n] = Integer.parseInt(reader.readLine());
        }
        for (int j=0; j< N; j++) {
            int amt = 0;
            for (int k=0; k < N; k++) {
                if(diamonds[k] >= diamonds[j] ) {
                    if (diamonds[k] <= diamonds[j] + K)
			amt++;
		}
            }
            if (amt > ANS)
                ANS = amt;
        }
        FileWriter f = new FileWriter("diamond.out");
        f.write(Integer.toString(ANS));
        f.close();
        
        
    }
    
}
