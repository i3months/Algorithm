import java.io.*;
import java.util.*;

  public class Main {

    public static boolean[] prime;
    public static void main(String[] args) throws IOException{ 

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      prime_check(M);

      for(int i = N; i<=M; i++){
        if(prime[i] == false){
          System.out.println(i);
        }
      }      
      

    }
    static void prime_check(int n){

      if(n<2){
        return;
      }

      prime = new boolean[n+1];
      prime[0] = true;
      prime[1] = true;

     

     for(int i= 2; i<= Math.sqrt(n); i++){
       if(prime[i] == true){  
         continue;
       }

       for(int j= i*i; j<prime.length; j = j+i){
         prime[j] = true;
       }

       
     }
      
    }

  }