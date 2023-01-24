#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;


int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int n, m;
	cin >> n >> m;

	vector<pair<ll, ll>> v(n);
	ll arr[1001][1001];
	ll dp[1001][11];

	memset(arr, 0, sizeof(arr));
	memset(dp, 0, sizeof(dp));

	for(int i=0; i<n; i++) {
		ll h, s;
		cin >> h >> s;
		v[i] = make_pair(h, s);
	}

	for(int i=0; i<n; i++) {
		ll h = v[i].first;
		ll s = v[i].second;
		arr[i][i] = s;

		for(int j=i+1; j<n; j++) {
			ll hh = v[j].first;
			ll ss = v[j].second;

			if(h < hh) {
				h = hh;
				s = ss;
				arr[i][j] = s;
				continue;
			}

			if(h > hh) {
				arr[i][j] = arr[i][j-1];
				continue;
			}

			if(h == hh) {
				s += ss;
				arr[i][j] = s;
				continue;
			}
		}
	}

	for(int i=0; i<n; i++) dp[i][0] = arr[0][i];

	for(int i=0; i<n; i++) {
		for(int j=1; j<m; j++) {
			for(int k=1; k<i+1; k++) {
				dp[i][j] = max(dp[i][j], dp[k-1][j-1] + arr[k][i]);
			}
		}
	}		

	cout << dp[n-1][m-1] << endl;
	
	


}

