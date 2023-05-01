#include <bits/stdc++.h>
#define endl "\n"

typedef long long ll;
using namespace std;

const int N = 1e7+10;
const int INF = 987654321;
const int INF2 = 1000000001;

ll n, x;
ll height[N];
ll area = 0;

deque<pair<ll, ll>> dq;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> x;
	
	for(int i=0; i<n; i++) {
		cin >> height[i]; 
		area += height[i];
	}

	for(int i=0; i<x; i++) {
		while(!dq.empty() && dq.back().second > height[i]) {
			dq.pop_back();
		}

		dq.push_back({i, height[i]});
	}

	// for(pair<int, int> k : dq) {
	// 	cout << k.first  << " " << k.second << endl;
	// }

	ll res = 0;
	ll idx = 0;
	ll target = dq.front().second;

	for(int i=x; i<n+1; i++) {
		while(!dq.empty() && dq.back().second > height[i]) {
			dq.pop_back();			
		}

		dq.push_back({i, height[i]});

		if(target != dq.front().second) {
			res += (i-idx-1) / x;
			res += 1;

			area -= (i-idx) * target;
			idx = i;
			target = dq.front().second;
		}

		if(dq.front().first > i-x) continue;

		int curIdx = dq.front().first;
		dq.pop_front();

		if(target != dq.front().second) {
			res += (curIdx-idx) / x;
			res += 1;

			area -= (curIdx-idx+1) * target;
			idx = curIdx+1;
			target = dq.front().second;
		}
	}

	cout << area << endl << res << endl;
}