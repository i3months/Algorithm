import java.util.*;
import java.io.*;
import java.math.*;

public class Main { 
    static int[][] map;
    static int N;
    static boolean[][] visit;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j <N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Queue<Locate> q = new LinkedList<>();
        q.add(new Locate(0,0));
        visit[0][0] = true;

        while(!q.isEmpty()){
            Locate cur = q.poll();
            
            int curR = cur.r;
            int curC = cur.c;

            if(curR == N-1 && curC == N-1){
                System.out.println("HaruHaru");
                return;
            }

            int num = map[curR][curC];

            //1
            int nextR = curR + num;
            int nextC = curC;

            if(nextR < N && !visit[nextR][nextC]){
                q.add(new Locate(nextR, nextC));
                visit[nextR][nextC] = true;
            }         
            

            //2
            nextR = curR;
            nextC = curC + num;

            if(nextC < N && !visit[nextR][nextC]){
                q.add(new Locate(nextR, nextC));
                visit[nextR][nextC] = true;
            }
        }

        System.out.println("Hing");

    }
}

class Locate{
    int r, c;
    Locate(int r, int c){
        this.r = r;
        this.c = c;
    }
}