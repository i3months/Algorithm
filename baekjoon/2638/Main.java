import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int cheese_cnt;    
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static ArrayList<Cheese> list;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];        
        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){
                    cheese_cnt++;
                    list.add(new Cheese(i, j));
                }
            }
        }

        int time = 0;

        while(cheese_cnt != 0){                    
            time++;
            visit = new boolean[N][M];

            dfs(0,0);
            melt();        
                        
        }

        System.out.println(time);

        
        
    }

    static void dfs(int r, int c){
        visit[r][c] = true;
        map[r][c] = 2;

        for(int i=0; i<4; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR >= N || nextR <= -1 || nextC >= M || nextC <= -1){
                continue;
            }

            if(visit[nextR][nextC]){
                continue;
            }

            if(map[nextR][nextC] == 1){
                continue;
            }

            dfs(nextR, nextC);
        }
    }

    static void melt(){        

        for(int i=0; i<list.size(); i++){
            int r = list.get(i).r;
            int c = list.get(i).c;
            int cnt = 0;

            for(int j=0; j<4; j++){
                int nextR = r + dr[j];
                int nextC = c+ dc[j];

                if(map[nextR][nextC] == 2){
                    cnt++;
                }
            }

            if(cnt >= 2){
                map[r][c] = 0;
                cheese_cnt--;
                list.remove(i);                   
                i--;
            }

        }       

    }
}

class Cheese{
    int r, c;
    Cheese(int r, int c){
        this.r = r;
        this.c = c;
    }
}