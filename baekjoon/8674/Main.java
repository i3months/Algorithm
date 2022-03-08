import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int cut = 0;
        long ans = 0;

        if(N>=M){
          if(N%2 == 0||M%2==0){
            ans = 0;
          }else{
            ans = M;
          }
          
        }else{
          if(M %2 == 0||N%2==0){
            ans = 0;
          }else{
            ans = N;
          }
          
        }
        

        
        System.out.println(ans);
        
    }
}