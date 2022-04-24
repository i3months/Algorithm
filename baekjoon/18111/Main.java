import java.util.*;
import java.io.*;

public class Main {   

    static int[] ans = new int[2];
    static int[][] map;
    static int N;
    static int M;
    static int B;
    static int stack;

    static int time_val = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int min = 1000000;
        int max = -1;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int tmp = Integer.parseInt(st.nextToken());                
                if(min > tmp){
                    min = tmp;
                }
                if(max < tmp){
                    max = tmp;
                }
                map[i][j] = tmp;
            }
        }

        bf(min, max);

        System.out.println(time_val + " " + stack);
        
        
    }

    static void bf(int min, int max){
        for(int i = min; i<max+1; i++){
            ans = bf2(i);

            if(time_val > ans[0]){
                time_val = ans[0];
                stack = ans[1];
            }else if(time_val == ans[0]){
                if(stack < ans[1]){
                    time_val = ans[0];
                    stack = ans[1];
                }
            }
        }
    }

    static int[] bf2(int s){
        int time = 0;
        int block_remain = B;

        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++){
                int val = map[i][j];

                if(val > s){ // 땅파기
                    time = time + (val - s) * 2;
                    block_remain = block_remain + (val - s);
                }

                if(val < s){
                    time = time + (s - val);
                    block_remain = block_remain - (s - val);
                }

            }
        }

        if(block_remain < 0){
            ans[0] = 1000000000;
            return ans;
        }

        ans[0] = time;
        ans[1] = s;

        return ans;
    }

}
