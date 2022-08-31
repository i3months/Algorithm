import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                    
        int N = Integer.parseInt(br.readLine());

        char[] arr = new char[N + 1];
        int[] dp = new int[N + 1];

        String str = br.readLine();

        for(int i=1; i<N+1; i++){
            arr[i] = str.charAt(i - 1);            
        }

        Arrays.fill(dp, 987654321);

        char before = ' ';
        char current = ' ';
        

        dp[1] = 0;

        for(int i=2; i<N+1; i++){            
            for(int j=1; j<i; j++){
                before = arr[j];
                current = arr[i];
                int val = i - j;

                if(before == 'B'){
                    if(current == 'O'){
                        dp[i] = Math.min(dp[i], dp[j] + val * val);
                    }
                }else
    
                if(before == 'O'){
                    if(current == 'J'){
                        dp[i] = Math.min(dp[i], dp[j] + val * val);
                    }
                }else
    
                if(before == 'J'){
                    if(current == 'B'){
                        dp[i] = Math.min(dp[i], dp[j] + val * val);
                    }
                }
            }
        }
        
        System.out.println(dp[N] == 987654321 ? -1 : dp[N]);

            

    }
}