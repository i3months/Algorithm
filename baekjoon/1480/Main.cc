#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <memory.h>
#include <cmath>

using namespace std;
typedef long long ll;
const int INF = 987654321;

int N, M, C;
int jewel[14];
int dp[1<<14][11][21];

int solve(int status, int bag, int weight) {
	int& ret = dp[status][bag][weight];

	if(bag == M) return -1;
	if(status == (1 << N) - 1) return 0;		
	if(ret != -1) return ret;

	ret = 0;

	for(int i=0; i<N; i++) {
		if(status & (1 << i)) continue;		
		if(jewel[i] > C) continue;

		if(weight + jewel[i] > C) {
			ret = max(ret, solve(status | (1 << i), bag + 1, jewel[i]) + 1);		
		} else {
			ret = max(ret, solve(status | (1 << i), bag, jewel[i] + weight) + 1);
		}
	}
	
	return ret;
}

int main() {
	cin.tie(0)->sync_with_stdio(0);

	cin >> N >> M >> C;
	
	for(int i=0; i<N; i++) cin >> jewel[i];

	memset(dp, -1, sizeof(dp));

	cout << solve(0, 0, 0) << endl;
	
}

