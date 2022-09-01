import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();     

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                            
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1]; 
        int ans = -1;       

        for(int i=1; i<N+1; i++){
            String str = br.readLine();
            for(int j=1; j<M+1; j++){
                int val = str.charAt(j - 1) - '0';
                
                if(i == 1 && j == 1){
                    map[i][j] = val;
                }else{
                    if(val == 1){
                        map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i][j-1], map[i-1][j])) + 1;
                    }
                }

                ans = Math.max(ans, map[i][j]);

            }
        }

        System.out.println(ans * ans);

        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        

    }
}