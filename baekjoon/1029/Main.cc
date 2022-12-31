#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <memory.h>

using namespace std;
typedef long long ll;

const int MAX1 = 16;
const int MAX2 = 10;
const int MAX3 = 1 << 16;

int N;
int dp[MAX1][MAX2][MAX3];
int priceArr[MAX1][MAX1];

int solve(int artist, int price, int visit) {
	int& ret = dp[artist][price][visit];
	if(ret != -1) return ret;

	ret = 0;

	for(int i=1; i<N; i++) {
		if(visit & (1 << i)) continue;
		if(priceArr[artist][i] < price) continue;

		// solve(i, priceArr[artist][i], visit | 1 << i)
		ret = max(ret, solve(i, priceArr[artist][i], visit | 1 << i) + 1);
	}

	return ret;

}

int main() {
	cin.tie(0)->sync_with_stdio(0);

	cin >> N;

	for(int i=0; i<N; i++) {
		string s;
		cin >> s;
		for(int j=0; j<N; j++) {					
			priceArr[i][j] = s[j] - '0';
		}
	}

	memset(dp, -1, sizeof(dp));

	cout << solve(0, 0, 1) + 1 << endl;

}

