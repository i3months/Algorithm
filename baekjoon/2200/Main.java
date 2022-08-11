import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;        

        for(int i=N-1; i>=0; i--){
            if(arr[i] != 0){                
                break;
            }
            cnt++;
        }

        int ans = 0;

        for(int i=0; i<N; i++){
            if(arr[i] == 1){
                int tmp = N - i - cnt;

                if(tmp == 0){
                    ans++;
                    ans++;
                }else{
                    ans += (tmp * 2)  - 1;
                    ans++;
                }
                
                
            }else if(arr[i] != 0){
                ans += String.valueOf(arr[i]).length() + 1;
                int tmp = N - i - cnt;

                if(tmp == 0){                    

                }else{
                    ans += (tmp * 2)  - 1;
                    ans++;
                }                
            }                                    
        }

        ans += (2 * cnt) - 1;

        if(arr[N] != 0){
            ans += String.valueOf(arr[N]).length() + 1;
        }

        System.out.println(ans + 1);

        

        
        
    }
}