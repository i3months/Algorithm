import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                    
        int[] dp = new int[41];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<41; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        int N = Integer.parseInt(br.readLine());

        int VIP_num = Integer.parseInt(br.readLine());

        if(N == VIP_num){
            System.out.println(1);
            return;
        }

        int[] vips = new int[VIP_num];

        for(int i=0; i<VIP_num; i++){
            vips[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(vips);

        int ans = 1;

        for(int i=0; i<VIP_num - 1; i++){
            int val = vips[i + 1] - vips[i] - 1;
            ans *= dp[val];
        }

        int val = vips[0] - 1;
        ans *= dp[val];

        val = N - vips[VIP_num - 1];

        ans *= dp[val];

        System.out.println(ans);
        

        
    

            

    }
    // static void bt(int depth){
    //     if(depth == N + 1){            
    //         max = Math.max(max, dp[N]);
    //         return;
    //     }

    //     int before = dp[depth - 1];

    //     if(before + arr[depth] <= M){
    //         dp[depth] = before + arr[depth];
    //         bt(depth + 1);
    //     }

    //     if(before - arr[depth] >= 0){
    //         dp[depth] = before - arr[depth];
    //         bt(depth + 1);
    //     }

    //     if(before + arr[depth] > M || before - arr[depth] < 0){
    //         return;
    //     }



    // }
}