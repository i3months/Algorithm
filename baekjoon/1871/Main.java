import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       

        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            
            String input = br.readLine();
            String a = input.split("-")[0];
            String b = input.split("-")[1];
            
            int valueA = 0;
            for(int j = 0; j < a.length(); j++){
                int value = a.charAt(j) - 'A';
                value *= Math.pow(26, 2 - j);
                valueA += value;
            }
            int valueB = Integer.parseInt(b);
            if(Math.abs(valueA - valueB) <= 100){
                System.out.println("nice");
            }else{
                System.out.println("not nice");
            }
            
        }

        
        
        
    }
}