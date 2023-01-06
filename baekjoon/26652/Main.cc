#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <memory.h>
#include <cmath>

using namespace std;
typedef long long ll;
const ll INF2 = 1800000000;
const ll INF = 1000000000000;

ll N, M, maxLevel;
vector<ll> level;
vector<ll> item;

ll isUpgrade(ll target, ll cur) {
	ll need = 0;
	if(target > cur) {
		need = (target - cur) * (target + cur - 1) / 2;
	}
	return need;
}

ll solve(ll stock, ll cur) {
	ll left = 0;
	ll right = INF2;

	ll ret = cur;
	
	while(left <= right) {
		ll mid = (left + right) / 2;
		
		if(isUpgrade(mid, cur) <= stock) {
			ret = max(ret, mid);
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}

	return ret;
}

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	maxLevel = 0;

	for(int i=0; i<N; i++) {
		ll a;
		cin >> a;
		level.push_back(a);
		maxLevel = max(maxLevel, level[i]);
	}

	for(int i=0; i<N; i++) {
		ll a;
		cin >> a;
		item.push_back(a);		
	}

	for(int i=0; i<N; i++) level[i] = solve(item[i], level[i]);

	ll minLevel = 0;

	ll L = 0;
	ll R = INF;
	
	while(L <= R) {
		ll mid = (L + R) / 2;
		
		ll sum = 0;
		
		for(int i=0; i<N; i++) {
			if(mid > level[i]) {
				sum += (mid - level[i]);
			}

			if(sum > INF) break;
		}

		if(sum <= M) {
			minLevel = max(minLevel, mid);
			L = mid + 1;
		} else {
			R = mid - 1;
		}
	}
	

	

	if(minLevel < maxLevel) cout << -1 << endl;
	else cout << minLevel << endl;
	
}