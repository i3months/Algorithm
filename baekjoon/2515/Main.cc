#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;


vector<pair<int, int>> v;
vector<int> dp;
vector<int> savev;

int n, s;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> s;

	v.resize(n+1);
	dp.resize(n+1);
	savev.resize(n+1);

	for(int i=1; i<n+1; i++) {
		cin >> v[i].first >> v[i].second;
	}

	sort(v.begin(), v.end());

	for(int i=1; i<n+1; i++) {
		for(savev[i]=savev[i-1]+1; savev[i] < i; savev[i]++) {
			if(v[i].first - v[savev[i]].first < s) break;
		}
		savev[i]--;
	}

	int ans = 0;

	for(int i=1; i<n+1; i++) {
		dp[i] = dp[savev[i]] + v[i].second; 
		dp[i] = max(dp[i], dp[i-1]);
	}

	// for(int i=1; i<n+1; i++) {
	// 	cout << savev[i] << endl;
	// }

	cout << endl;

	cout << dp[n] << endl;

}