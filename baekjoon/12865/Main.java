import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Bag[] arr = new Bag[N + 1];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[][] dp = new int[N + 1][K + 1];

        for(int i=1; i<N+1; i++){
            for(int j=1; j<K+1; j++){
                
                if(arr[i].weight > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - arr[i].weight] + arr[i].value);
                }

            }
        }

        System.out.println(dp[N][K]);

        for(int i=1; i<N+1; i++){
            for(int j=1; j<K+1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        

    }
}

class Bag{
    int weight, value;

    Bag(int weight, int value){
        this.weight = weight;
        this.value = value;
    }
    
}
