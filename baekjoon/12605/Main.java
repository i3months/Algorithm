import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i= 1; i< N+1; i++){
          String[] arr = br.readLine().split(" ");          
          System.out.print("Case " + "#" + i + ": ");
          for(int j=arr.length-1; j>=0; j--){
            System.out.print(arr[j]+ " ");
          }
          System.out.println();
        }
        
        
    }
}
