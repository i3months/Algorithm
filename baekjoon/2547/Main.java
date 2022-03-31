import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());
        
        for(long i = 0; i<N; i++){
            br.readLine();
            long K = Long.parseLong(br.readLine());

            long sum = 0;
            for(long j = 0; j<K; j++){
                long temp = Long.parseLong(br.readLine());
                sum = sum + temp % K;                
            }

            if(sum % K == 0){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}