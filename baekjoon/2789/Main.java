import java.util.*;

import javax.swing.plaf.synth.SynthButtonUI;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
     
        String str = br.readLine();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'C' || str.charAt(i) == 'A' || str.charAt(i) == 'M' || str.charAt(i) == 'B' || str.charAt(i) == 'R' || str.charAt(i) == 'I' || str.charAt(i) == 'D' || str.charAt(i) == 'G' || str.charAt(i) == 'E'){
                sb.append("");
            }else{
                sb.append(str.charAt(i));
            }
        }

        System.out.println(sb);
    }
}