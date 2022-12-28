import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N+1][M+1];

            for(int i=1; i<N+1; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<M+1; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int L = 1;
            int R = Math.min(N, M);
            int ans = 0;

            while(L <= R) {
                int mid = (L + R) / 2;
                if(check(mid)) {
                    ans = mid;
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }

            sb.append(ans + "\n");
        }

        System.out.println(sb);


    }   
    static boolean check(int num) {

        int[][] originArr = new int[N+1][M+1];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++) {
                originArr[i][j] = map[i][j];
            }
        }

        int[][] newArr = new int[N+2][M+2];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++) {
                if(originArr[i][j] >= num) originArr[i][j] = 1;
                else originArr[i][j] = 0;        

                newArr[i+1][j+1] = newArr[i][j+1] + newArr[i+1][j] - newArr[i][j] + originArr[i][j];                                
            }
        }

        for(int i=num; i<N+2; i++) {
            for(int j=num; j<M+2; j++) {
                int sum = newArr[i][j] - newArr[i][j-num] - newArr[i-num][j] + newArr[i-num][j-num];
                
                if(sum == num * num) return true;
            }
        }
        
        return false;
    }
}