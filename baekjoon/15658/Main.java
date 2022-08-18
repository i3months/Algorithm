import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    static boolean[] visit;
    static int[] nums;
    static int[] operators;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        operators = new int[4];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());

        for(int i =0; i<4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        bt(1,nums[0]);

        System.out.println(max);
        System.out.println(min);

        
    }

    static void bt(int depth, int num){
        if(depth == N){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for(int i=0; i<4; i++){
            if(!visit[depth] && operators[i] > 0){
                visit[depth] = true;
                operators[i]--;
                
                int nextNum = 0;

                if(i == 0){
                    nextNum = num + nums[depth];
                }

                if(i == 1){
                    nextNum = num - nums[depth];
                }
                
                if(i == 2){
                    nextNum = num * nums[depth];
                }

                if(i == 3){
                    nextNum = num / nums[depth];
                }
                
                bt(depth + 1, nextNum);

                visit[depth] = false;
                operators[i]++;
                
            }
        }


    }
}