import java.io.*;
import java.util.*;
 
public class Main {
    static int N, M, K;

    static int[][] map;
    static boolean[][] visit;    

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static ArrayList<Integer> list = new ArrayList<>();
    static int cnt;
    static int total_cnt;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit = new boolean[M][N];

        Square[] arr = new Square[K];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<K; i++){
            Square cur = arr[i];

            for(int j = cur.start_c; j<cur.fin_c  ; j++){
                for(int k = cur.start_r; k<cur.fin_r; k++){
                    map[j][k] = 1;
                }
            }

        }
        

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){

                if(!visit[i][j] && map[i][j] == 0){
                    total_cnt++;
                    bfs(i,j);
                }   

            }
        }

        Collections.sort(list);

        System.out.println(total_cnt);
        for(int k : list){
            System.out.print(k + " ");
        }

        
        
        
    }

    static void bfs(int r, int c){
        cnt = 0;

        Queue<Locate> q = new LinkedList<>();
        q.add(new Locate(r,c));
        cnt++;
        visit[r][c] = true;

        while(!q.isEmpty()){
            Locate cur = q.poll();

            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR >= M || nextR <= -1 || nextC >= N || nextC <= -1){
                    continue;
                }

                if(map[nextR][nextC] != 0){
                    continue;
                }

                if(visit[nextR][nextC]){
                    continue;
                }

                q.add(new Locate(nextR, nextC));
                visit[nextR][nextC] = true;
                cnt++;
            }
        }

        list.add(cnt);
        
        
    }
}

class Square{
    int start_r, fin_r, start_c, fin_c;

    Square(int start_r, int start_c, int fin_r, int fin_c){
        this.start_r = start_r;
        this.start_c = start_c;
        this.fin_r = fin_r;
        this.fin_c = fin_c;
    }
}

class Locate{
    int r,c;
    Locate(int r, int c){
        this.r = r;
        this.c = c;
    }
}