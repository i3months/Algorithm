import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int INF = 987654321;
    static double[][] arr;
    static int N;
    static double[][] cost;
    static int ansState;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new double[N][N];
        cost = new double[N][1 << 17];
        ansState = (1 << N) - 1;

        double[][] tmp = new double[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tmp[i][0] = Double.parseDouble(st.nextToken());
            tmp[i][1] = Double.parseDouble(st.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i == j) continue;
                
                double val = Math.pow(tmp[i][0] - tmp[j][0], 2) + Math.pow(tmp[i][1] - tmp[j][1], 2);
                val = Math.sqrt(val);

                arr[i][j] = val;
                
            }
        }
     
        
        for(int i=0; i<N; i++){
            Arrays.fill(cost[i], -1);
        }    

        System.out.println(dfs(0,1));
        
    }

    static double dfs(int curNode, int curState){
        if(curState == ansState){
            return arr[curNode][0] == 0 ? INF : arr[curNode][0];            
        }

        if(cost[curNode][curState] != -1) return cost[curNode][curState];
        cost[curNode][curState] = INF;

        for(int i=0; i<N; i++){
            if(arr[curNode][i] == 0) continue;
            if((curState & (1 << i)) == (1 << i)) continue;

            cost[curNode][curState] = Math.min(cost[curNode][curState], arr[curNode][i] + dfs(i, curState | 1 << i));
        }
        return cost[curNode][curState];
    }
}