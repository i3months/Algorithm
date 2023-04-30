	#include <bits/stdc++.h>
	#define endl "\n"

	typedef long long ll;
	using namespace std;

	const int N = 1e7+10;
	const int INF = 987654321;
	const int INF2 = 1000000001;

	deque<ll> dq;
	vector<ll> v;

	int TC, n, m, k;

	int main() {
		ios::sync_with_stdio(false);
		cin.tie(0);

		cin >> TC;

		while(TC--) {
			ll ans = 0;
			ll cur = 0;
			cin >> n >> m >> k;
			v.clear();
			v.resize(n);
			dq.clear();

			for(int i=0; i<n; i++) cin >> v[i];
			for(int i=0; i<m; i++){
				dq.push_back(v[i]);
				cur += v[i];
			} 

			if(cur < k) ans++;

			if(n == m) {
				cout << ans << endl;
				continue;
			}
			
			for(int i=0; i<n-1; i++) {
				dq.pop_front();
				cur -= v[i];
				dq.push_back(v[(i+m)%n]);
				cur += v[(i+m)%n];

				if(cur < k) ans++;						
			}

			cout << ans << endl;

							
		}

	}