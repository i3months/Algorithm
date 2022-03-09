import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        int seq = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
          int num = Integer.parseInt(st.nextToken());
          if(num == 1){
            seq++;
            ans = ans + seq;
          }else if(num == 0){
            seq = 0;
          }
        }

        System.out.println(ans);
      

    }
}