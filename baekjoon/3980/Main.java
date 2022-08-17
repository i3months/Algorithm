import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int TC;
    static int[][] map;
    static boolean[] visit;

    static int ans;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        
        TC = Integer.parseInt(br.readLine());

        while(TC-- > 0){
            map = new int[11][11];
            visit = new boolean[11];
            ans = 0;

            for(int i=0; i<11; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<11; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bt(0,0);

            sb.append(ans + "\n");
            
            
        }

        System.out.println(sb);
        

    }

    static void bt(int num, int sum){

        if(num == 11){
            ans = Math.max(ans, sum);
            return;
        }
            
        for(int i=0; i<11; i++){
            if(!visit[i] && map[num][i] != 0){
                visit[i] = true;
                bt(num + 1, sum + map[num][i]);
                visit[i] = false;
            }
        }
        
        

        
    }
}