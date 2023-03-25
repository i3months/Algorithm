#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int n;
vector<pair<ll, ll>> v;
vector<ll> sum;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> n;

	for(int i=0; i<n; i++) {
		ll tmp1, tmp2;
		cin >> tmp1 >> tmp2;
		v.push_back({tmp1, tmp2});
	}		

	sort(v.begin(), v.end());
	sum.resize(n+1);
		
	sum[0] = v[0].second;
	for(int i=1; i<n; i++) sum[i] = sum[i-1] + v[i].second;

	ll start = 0; 
	ll end = n-1;
	ll ans = INF2;

	while(start <= end) {
		ll mid = (start + end) / 2;
		if(sum[mid] >= sum[n-1] - sum[mid]) {
			end = mid - 1;
			ans = min(ans, v[mid].first);
		} else {
			start = mid + 1;
		}
	}

	cout << ans << endl;
	
	
	

}