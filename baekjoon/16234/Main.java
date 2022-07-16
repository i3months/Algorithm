import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visit;
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static ArrayList<Country> list;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        while(true){
            boolean move_chk = false;
            visit = new boolean[N][N];            

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j]){
                        int sum = bfs(i,j);
                        if(list.size() >= 2){
                            int average = sum / list.size();
                            for(Country country : list){
                                map[country.r][country.c] = average;
                                move_chk = true;
                            }
                        }
                    }
                }
            }

            if(!move_chk){
                break;
            }
            cnt++;
            
        }


        System.out.println(cnt);
        

        
    }

    static int bfs(int r, int c){
        Queue<Country> q = new LinkedList<>();

        list = new ArrayList<>();

        q.add(new Country(r,c));
        list.add(new Country(r,c));
        visit[r][c] = true;

        int sum = map[r][c];

        while(!q.isEmpty()){
            Country cur = q.poll();

            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR <= -1 || nextR >= N || nextC <= -1 || nextC >= N){
                    continue;
                }

                if(visit[nextR][nextC]){
                    continue;
                }
                
                int sub = Math.abs(map[cur.r][cur.c] - map[nextR][nextC]);
                if(L <= sub && sub <= R){
                    q.add(new Country(nextR, nextC));
                    list.add(new Country(nextR, nextC));
                    visit[nextR][nextC] = true;                    
                    sum = sum + map[nextR][nextC];
                }
                
            }
        }

        return sum;
        
    }
    
}

class Country{
    int r, c;
    Country(int r, int c){
        this.r = r;
        this.c = c;
    }
}