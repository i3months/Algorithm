#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

const int N = 1e7+10;

ll w[N], h[N];
int n;
bool solve(ll W, ll H) {

	set<pair<ll, ll>> s1, s2;

	for (int i = 1; i <= n; i++) {
		s1.insert(make_pair(w[i], i));
		s2.insert(make_pair(h[i], i));			
	}

	while (!s1.empty()) {
		if (W == (*--s1.end()).first) {
			int idx = (*--s1.end()).second;
			H -= h[idx];
			s1.erase({ w[idx],idx });
			s2.erase({ h[idx],idx });
		} else {
			if (H != (*--s2.end()).first) return false;			
			int idx = (*--s2.end()).second;
			W -= w[idx];
			s1.erase({ w[idx],idx });
			s2.erase({ h[idx],idx });
		}
	}
	return true;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int TC;
	cin >> TC;

	while(TC--) {
		cin >> n;

		ll maxW = -1, maxH = -1;
		ll area = 0;

		for(int i=1; i<n+1; i++) {
			cin >> w[i] >> h[i];
			maxW = max(maxW, w[i]);
			maxH = max(maxH, h[i]);
			area += (w[i] * h[i]);
		}

		vector<pair<ll, ll>> ans;

		if(area % maxW == 0 && solve(maxW, area / maxW)) ans.push_back(make_pair(maxW, area / maxW));
		if(area % maxH == 0 && solve(area / maxH, maxH)) ans.push_back(make_pair(area / maxH, maxH));

		if(ans.size() == 2) {
			if(ans[0] == ans[1]) {
				ans.pop_back();
			}
		}

		cout << ans.size() << endl;
		for(auto &k : ans) {
			cout << k.first << " " << k.second << endl;
		}

		
		
	}
}