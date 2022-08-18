import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static boolean[] select;
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        select = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bt(0, 0);

        System.out.println(ans);
    }

    static void bt(int idx, int depth){
        

        if(depth == N / 2){
            int sum1 = 0;
            int sum2 = 0;

            for(int i=0; i<N - 1; i++){
                for(int j=i + 1; j<N; j++){
                    if(select[i] && select[j]){
                        sum1 += map[i][j];
                        sum1 += map[j][i];
                    }

                    if(!select[i] && !select[j]){
                        sum2 += map[i][j];
                        sum2 += map[j][i];
                    }
                }
            }
           

            int sub = Math.abs(sum1 - sum2);

            ans = Math.min(ans, sub);

            return;
        }

        for(int i=idx; i<N; i++){
            if(!select[i]){
                select[i] = true;
                bt(i + 1, depth + 1);
                select[i] = false;
            }
        }
        

    }
}