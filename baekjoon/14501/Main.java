import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        Consult[] arr = new Consult[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Consult(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));            
        }

        int[] dp = new int[N+1];

        for(int i=0; i<N; i++){
            if(i + arr[i].day <= N){
                dp[i + arr[i].day] = Math.max(dp[i + arr[i].day], dp[i] + arr[i].pay);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N]);

        
    }
}    

class Consult{
    int day, pay;

    Consult(int day, int pay){
        this.day = day;
        this.pay= pay;
    }
}
