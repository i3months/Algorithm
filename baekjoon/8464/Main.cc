#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

ll k;
ll sign[1400000] = {0,};

ll solve(ll n) {
	ll ans = 0;
	for(ll i=1; i*i<n+1; i++) {
		ans += (sign[i] * (n / (i*i)));
	}

	return ans;
}

void preperation() {
	sign[1] = 1;
	for(ll i=1; i<1000001; i++) {
		for(ll j=i*2; j<1000001; j+=i) {
			sign[j] -= sign[i];
		}
	}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	preperation();

	cin >> k;

	ll left = 0;
	ll right = 100000000000;
	ll ans = -1;

	while(left <= right) {
		ll mid = (left + right) / 2; 		

		if(mid - solve(mid) < k) {
			left = mid + 1;
		} else {
			right = mid - 1;
			ans = mid;
		}
	}

	cout << ans << endl;	

}