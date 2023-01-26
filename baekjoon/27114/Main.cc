#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int l, r, b, k;
const int INF = 1000001;

int arr[6][2];
int dp[INF];

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);
	
	cin >> l >> r >> b >> k;

	memset(arr, 0, sizeof(arr));

	arr[0][0] = l+r; arr[0][1] = 2;
	arr[1][0] = 4*l; arr[1][1] = 4;
	arr[2][0] = 4*r; arr[2][1] = 4;
	arr[3][0] = 2*l+b; arr[3][1] = 3;
	arr[4][0] = 2*r+b; arr[4][1] = 3;
	arr[5][0] = 2*b; arr[5][1] = 2;
	
	for(int i=1; i<k+1; i++) {
		dp[i] = INF;
		for(int j=0; j<6; j++) {
			if(i - arr[j][0] >= 0) dp[i] = min(dp[i], dp[i-arr[j][0]] + arr[j][1]);
		}
	}

	if(dp[k] == INF) cout << -1 << endl;
	else cout << dp[k] << endl;
	

}

