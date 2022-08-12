import java.util.*;
import java.io.*;
import java.math.*;

public class Main {   
    static int N; 

    static int[][] map;
    static int[][] A;
    static ArrayList<Integer>[][] tree;
    static int[][] death;
    
    static int dr[] = {0,0,-1,1,-1,1,-1,1};
    static int dc[] = {-1,1,0,0,-1,1,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        A = new int[N][N];
        tree = new ArrayList[N][N];        

        for(int[] k : map){
            Arrays.fill(k, 5);
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                tree[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());

            tree[r][c].add(age);
        }

        for(int i=0; i<K; i++){
            spring();
            summer();
            fall();
            winter();
        }

        int ans = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!tree[i][j].isEmpty()){
                    ans += tree[i][j].size();
                }
            }
        }

        System.out.println(ans);
        

        
        
        
    }

    static void spring(){
        death = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!tree[i][j].isEmpty()){
                    Collections.sort(tree[i][j]);

                    for(int k=0; k<tree[i][j].size(); k++){
                        if(map[i][j] >= tree[i][j].get(k)){
                            map[i][j] -= tree[i][j].get(k);
                            tree[i][j].set(k, tree[i][j].get(k) + 1);
                        }else{
                            death[i][j] += tree[i][j].get(k) / 2;
                            tree[i][j].remove(k);
                            k--;// need to fix
                        }
                    }
                }        
            }
        }
    }

    static void summer(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] += death[i][j];
            }
        }
    }

    static void fall(){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                if(!tree[i][j].isEmpty()){
                    for(int k=0; k<tree[i][j].size(); k++){
                        if(tree[i][j].get(k) % 5 == 0){
                            for(int a = 0; a < 8; a ++){
                                int nextR = i + dr[a];
                                int nextC = j + dc[a];

                                if(nextR >= N || nextR <= -1 || nextC >= N || nextC <= -1){
                                    continue;
                                }
                                
                                tree[nextR][nextC].add(1);
                            }
                        }        
                    }
                }
            }
        }
    }

    static void winter(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] += A[i][j];
            }
        }
    }
}