import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      long N = sc.nextLong();
      long M = sc.nextLong();
      long temp;

      if(N > M){
        temp = N;
        N = M;
        M = temp;
      }

      if(N == M){
        System.out.println(0);
      }else{
        System.out.println(M - N -1);
      }


      for(long i = N+1; i<M; i++){

        
        
        System.out.print(i + " ");
      }
      
    }
}