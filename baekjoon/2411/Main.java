import java.util.*;
import java.io.*;
import java.math.*;

public class Main {        
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][M + 1];
        int[][] map = new int[N+1][M+1];

        ArrayList<Locate> list = new ArrayList<>();
        
        for(int i=0; i<A; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Locate(a,b));
            map[a][b] = 1;            
        }

        int startR = 1;
        int startC = 1;

        for(int i=0; i<B;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = -1;
        }

        list.add(new Locate(N, M));

        Collections.sort(list);

        dp[1][0] = 1;

        for(int item = 0; item<list.size(); item++){
            int finR = list.get(item).r;
            int finC = list.get(item).c;

            for(int i=startR; i<finR+1; i++){
                for(int j=startC; j<finC+1; j++){
                    if(map[i][j] ==-1){
                        dp[i][j] = 0;
                    }else if(map[i-1][j] != -1 && map[i][j-1] != -1){
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }else if(map[i-1][j] !=-1){
                        dp[i][j] = dp[i-1][j];
                    }else if(map[i][j-1]!=-1){
                        dp[i][j] = dp[i][j-1];
                    }
                }                
            }

            startR = finR;
            startC = finC;
        } 
        System.out.println(dp[N][M]);     
        
        // for(int i=1; i<N+1; i++){
        //     for(int j=1; j<M+1; j++){
        //         System.out.print(dp[i][j]+ " ");
        //     }System.out.println();
        // }

    }
}

class Locate implements Comparable<Locate>{
    int r,c;
    Locate(int r, int c){
        this.r=r;
        this.c=c;
    }

    public int compareTo(Locate o2){
        if(r < o2.r){
            return 1;
        }else if(r == o2.r){
            if(c < o2.c) return 1;
        }
        return 0;
    }
}