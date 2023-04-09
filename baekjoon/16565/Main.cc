#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int mod = 10007;
int dp[55][55];
int n;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	memset(dp, 0, sizeof(dp));

	for(int i=0; i<53; i++) {
		dp[i][0] = 1;		
	}

	for(int i=1; i<53; i++) {
		for(int j=1; j<53; j++) {
			dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % mod;							
		}
	}

	int ans = 0;
		   
    for (int i = 4; i <= n; i += 4) {
        if ((i / 4) % 2 == 1) ans = (ans + dp[13][i/4] * dp[52 - i][n - i]) % mod;
        else ans = (ans - dp[13][i/4] * dp[52 - i][n - i]) % mod;
    }

	if(ans < 0) ans += mod;
	
	cout << ans << endl;


}