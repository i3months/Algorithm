import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int ans = 0;
    static int[] arr = new int[10];
    static int[] select = new int[10];
    static boolean[] visit = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<10 ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bt(0);

        System.out.println(ans);


    }

    static void bt(int depth){
        if(depth == 10){
            
            int cnt = 0;
            for(int i=0; i<10; i++){
                if(arr[i] == select[i]){
                    cnt++;
                }
            }

            if(cnt >= 5){
                ans++;
            }

            return;
        }

        for(int i=1; i<6; i++){
            
            if(depth >= 2){
                if(select[depth - 2] == select[depth - 1] && select[depth - 2] == i){                    
                    continue;
                }
            }

            if(!visit[depth]){
                visit[depth] = true;
                select[depth] = i;
                bt(depth + 1);
                visit[depth] = false;
                select[depth] = 0;
            }


        }
        

    }
}