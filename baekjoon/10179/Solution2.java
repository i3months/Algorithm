import java.util.*;
import java.io.*;

public class Solution2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            double tmp = Double.parseDouble(br.readLine());
            
            System.out.printf("$%.2f", tmp * 0.8);
        }
    }
}