import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    
    static int dir = 2;

    static int N, M, x, y;

    static boolean chk = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());        

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(cmd.equals("MOVE")){
                for(int j=0; j<num; j++){
                    x += dx[dir];
                    y += dy[dir];
                }

                if(x >= N+1 || x <= -1 || y >= N+1 || y <= -1){
                    System.out.println(-1);         
                    // System.out.println(x + " " + y);           
                    return;
                }
            }

            if(cmd.equals("TURN")){
                if(num == 0){
                    dir++;
                    if(dir== 4){
                        dir=  0;
                    }
                }

                if(num == 1){
                    dir--;
                    if(dir == -1){
                        dir = 3;
                    }
                }
            }
        }    

        System.out.println(x + " " + y);

        
    }
}