#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <memory.h>
#include <cmath>

using namespace std;
typedef long long ll;
const int INF = 987654321;

int N, P;
int cost[17][17];
int dp[1<<17];
string status1;
int status2;

int solve(int status) {
	int count = 0;
	int statusCopy = status;	
	while(statusCopy != 0) {
		count += (statusCopy & 1);
		statusCopy >>= 1;
	}

	if(count >= P) return 0;
	if(dp[status] != -1) return dp[status];
	
	int& ret = dp[status];
	ret = INF;

	for(int i=0; i<N; i++) {
		if((status & (1 << i)) == 0) continue;
		for(int j=0; j<N; j++) {
			if((status & (1 << j)) != 0) continue;
			int next = status | (1 << j);
			ret = min(ret, cost[i][j] + solve(next));
		}
	}

	return ret;
	
}

int main() {
	cin.tie(0)->sync_with_stdio(0);

	cin >> N;
	
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {
			cin >> cost[i][j];
		}
	}

	cin >> status1;
	cin >> P;	

	status2 = 0;

	int idx = -1;
	for(int i=0; i<status1.size(); i++) {
		idx++;
		char c = status1[i];
		if(c == 'N') continue;

		int tmp = pow(2, idx);
		status2 += tmp;  								
	}

	// cout << status2 << endl;	

	memset(dp, -1, sizeof(dp));
	int ans = INF;

	ans = solve(status2);	

	if(ans == INF) cout << -1 << endl;
	else cout << ans << endl;
	

}

