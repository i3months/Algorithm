import java.io.*;
import java.util.*;
 
public class Main {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static int N, M;
    static int map[][];
    static int ans[][];    
    static int update[][];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                        

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];        
        ans = new int[N][M];
        update = new int[N][M];

        int idx = 10;

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j) - '0';
                if(map[i][j] == 1) map[i][j] = -1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                           
                if(map[i][j] == 0){
                    ArrayList<Locate> list = new ArrayList<>();
                    list.add(new Locate(i,j));

                    int cnt = 1;
                    boolean[][] visit = new boolean[N][M];
                    visit[i][j] = true;

                    Queue<Locate> q = new LinkedList<>();
                    q.add(new Locate(i,j));

                    while(!q.isEmpty()){
                        Locate cur = q.poll();

                        for(int a=0; a<4; a++){
                            int nextR = cur.r + dr[a];
                            int nextC = cur.c + dc[a];

                            if(nextR >= N || nextR <= -1 || nextC >= M || nextC <= -1) continue;
                            if(visit[nextR][nextC]) continue;
                            if(map[nextR][nextC] == -1) continue;

                            list.add(new Locate(nextR, nextC));
                            cnt++;
                            visit[nextR][nextC] = true;
                            q.add(new Locate(nextR, nextC));
                        }
                    }

                    for(Locate k : list){
                        map[k.r][k.c] = cnt;
                        update[k.r][k.c] = idx;
                    }
                    idx++;

                }

            }
        }


        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                
                if(map[i][j] == -1){
                    HashSet<Integer> hs = new HashSet<>();

                    for(int a=0; a<4; a++){
                        int nextI = i + dr[a];
                        int nextJ = j + dc[a];

                        if(nextI >= N || nextI <= -1 || nextJ >= M || nextJ <= -1) continue;
                        if(map[nextI][nextJ] == -1) continue;
                        if(hs.contains(update[nextI][nextJ])) continue;

                        ans[i][j] += map[nextI][nextJ];
                        hs.add(update[nextI][nextJ]);
                        
                    }
                    ans[i][j]++;
                }else{
                    ans[i][j] = 0;
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(ans[i][j]);
                // System.out.print(ans[i][j]);
            }
            sb.append("\n");
            // System.out.println();
        }

        System.out.print(sb);
        
        // for(int i=0; i<N; i++){
        //     for(int j=0; j<M; j++){                
        //         System.out.print(update[i][j]);
        //     }            
        //     System.out.println();
        // }
        
    }
}

class Locate{
    int r,c;
    Locate(int a, int b){r=a;c=b;}
}