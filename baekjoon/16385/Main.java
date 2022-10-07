import java.util.*;
import java.io.*;
import java.math.*;

class Main {
    static int INF = 987654321;    
    static int N;
	static int M;
    static int[][] dp;


    static int ansState;
	static HashMap<String, ArrayList<Integer>> overlap = new HashMap<>();
	static int[] locateX;
	static int[] locateY;
	static int[] pokeName;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        		

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][1<<23];		
		locateX = new int[N];
		locateY = new int[N];
		pokeName = new int[N];
		HashMap<String, Integer> hm = new HashMap<>();
		M = 0;

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			locateX[i] = Integer.parseInt(st.nextToken());
			locateY[i] = Integer.parseInt(st.nextToken());

			String name = st.nextToken();

			if(hm.containsKey(name)){
				pokeName[i] = hm.get(name);
			}else{
				hm.put(name, M);
				pokeName[i] = M;
				M++;			
			}			
		}

		int res = INF;
		ansState = (1 << M) - 1;

		for(int i=0; i<N; i++){
			res = Math.min(res, dfs(i, 1 << pokeName[i]) + Math.abs(locateX[i]) + Math.abs(locateY[i]));
		}

		System.out.println(res);
		
        
    }

    static int dfs(int curNode, int curState){

		if(curState == ansState) return dp[curNode][curState] = Math.abs(locateX[curNode]) + Math.abs(locateY[curNode]);
		if(dp[curNode][curState] != 0) return dp[curNode][curState];                
    
		dp[curNode][curState] = INF;		

        for(int i=0; i<N; i++){
			if(i == curNode) continue;

			dp[curNode][curState] = Math.min(dp[curNode][curState], dfs(i, curState | 1 << pokeName[i]) + Math.abs(locateX[i] - locateX[curNode]) + Math.abs(locateY[i] - locateY[curNode]));
		}
		
        return dp[curNode][curState];
    }
}