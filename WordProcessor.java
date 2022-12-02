



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

/**
 *
 * @author Liu Home Desktop
 */
public class WordProcessor {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
       BufferedReader objReader = new BufferedReader(new FileReader("word.in"));
       PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
       int k = Integer.parseInt(objReader.readLine().split(" ")[1]);
       String sentence = objReader.readLine();
       String[] input =sentence.split(" ");
       ArrayList<String> line = new ArrayList<String>();
       int sum=0;
       int x =0;
       for (String word: input) {
           sum += word.length();
           if (sum<=k ) {
               line.add(word);
           } else {
              String output = String.join(" ", line);
              pw.println(output);
              
              line.clear();
              line.add(word);
              sum=word.length();
               
           }

           
           
       }
       String output = String.join(" ", line);
       pw.println(output);
       pw.close();
       
        
       
       
    }
    
}
