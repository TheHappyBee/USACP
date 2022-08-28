/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.io.*;
/**
 *
 * @author Liu Home Desktop
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int ans = 1;
        for (int i=0; i < b.length()-1; i++) {
            if (a.indexOf(b.toCharArray()[i+1]+"") <= a.indexOf(b.toCharArray()[i]+"")) {
                ans++;
            }
        }
        System.out.println(ans);
        
        
    }
    
}
