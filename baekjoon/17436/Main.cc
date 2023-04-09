#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;


ll n, m, ans;
vector<int> v;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;
	v.resize(n);

	for(int i=0; i<n; i++) cin >> v[i];

	for(int i=1; i<(1 << n); i++) {
		int cnt = __builtin_popcount(i);
		ll num = 1;
		for(int j=0; j<n; j++) {
			if(i & (1 << j)) num *= v[j];
		}

		if(cnt % 2 == 1) ans += (m / num);
		else ans-= (m / num);
	}

	cout << ans << endl;
	

}