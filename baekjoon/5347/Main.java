import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long max = Math.max(a,b);
            long min = Math.min(a,b);

            long asdf = gcd(max, min);

            long ans = (max * min) / asdf;

            System.out.println(ans);
        }


    }
    static long gcd(long a, long b) {
        // a > b 임을 가정함
       while(b != 0) {
           long r = a % b;
           a = b;
           b = r;
       }
       return a;
   }
}