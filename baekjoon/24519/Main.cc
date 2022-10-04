#include <bits/stdc++.h>
using namespace std;

#define FOR(i,a,b) for(int i=(a);i<=(b);i++)
#define INF 2e9


int N, M;
vector<vector<int>> Edge(18, vector<int>());
vector<vector<int>> cost(18, vector<int>(18, 0));
vector<vector<int>> dp(18, vector<int>(1 << 18, -1));
vector<int> route(18, -1);
int ans;

int DP(int node, int bm) {
	if (bm == (1 << N) - 1) {
		return dp[node][bm] = (cost[node][0] == 0 ? INF : cost[node][0]);
	}
	int& ret = dp[node][bm];
	if (ret != -1) {
		return ret;
	}
	ret = INF;
	for (int next : Edge[node]) {
		if (bm & (1 << next)) continue;
		int tmp = DP(next, bm | (1 << next));
		ret = min(ret, max(tmp, cost[node][next]));
	}
	return ret;
}

void trace(int node, int bm, int depth) {    
	route[depth] = node;
	if (bm == (1 << N) - 1) {
		// if (cost[node][0] != 0) {			
			FOR(i, 0, N - 1) {
				cout << route[i] + 1 << " ";
			}
            cout<<"\n";

    //         for(int i=0; i<N; i++){
    //     for(int j=0; j<N; j++){
    //         cout<<cost[i][j];
    //         cout<<" ";
    //     }
    //     cout<<"\n";
    // }

    // cout<<"\n";

    //         for(int i=0; i<N; i++){
    //     for(int j=0; j<20; j++){
    //         cout<<dp[i][j];
    //         cout<<" ";
    //     }
    //     cout<<"\n";
    // }
			exit(0);
		// }
		return;
	}
	for (int next : Edge[node]) {
		if (bm & (1 << next)) continue;
        int a = dp[node][bm];
        int b = dp[next][bm | (1 << next)];
        int c = cost[node][next];

        // cout <<a;
        // cout<<" ";
        // cout <<b;
        // cout<<" ";
        // cout <<c;
        // cout<<" \n";

        
		if (a == max(b, c)) {
			trace(next, bm | (1 << next), depth + 1);
		}
	}

    /**
     * for (int next : Edge[node]) {
		if (bm & (1 << next)) continue;
		int tmp = DP(next, bm | (1 << next));
		ret = min(ret, max(tmp, cost[node][next]));
	}
     * 
     */
}

int main() {	
	cin >> N >> M;
	FOR(m, 1, M) {
		int u, v, c;
		cin >> u >> v >> c;
		Edge[u - 1].push_back(v - 1);
		cost[u - 1][v - 1] = c;
	}
	ans = DP(0, 1);

    if(ans == INF){
        cout << -1;
    }else{
        cout << ans;
        cout << "\n";
        trace(0, 1, 0);	
    }	

	return 0;
}

  // for(int k : edge[curNode]){
        //     if((curState & (1 << k)) != 0) continue;
        //     if((curState & (1 << k)) == (1 << k)) continue;

        //     int a = cost[curNode][curState];
        //     int b = cost[k][curState | (1 << k)];
        //     int c = cost[curNode][k];

        //     System.out.println(a + " " + b  + " " + c);

        //     if(a == Math.max(b, c)){                
        //         trace(k, curState | (1 << k), depth + 1);
        //     }
        // }