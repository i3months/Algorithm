//#pragma GCC target("trapv")
#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <string>
#include <cmath>
#include <map>
#include <iostream>
#include <list>
#include <stack>
#include <cassert>
using namespace std;

typedef long long ll;
typedef long double ld;

#define fastInp cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(0);

const ll INF = 1e9 * 1e9 + 100, SZ = 1100;

ll n;
vector<pair<ll, ll>> vec;
map<ll, pair<ll, ll>> blocks;

pair<ll, ll> solve() {
	set<pair<ll, ll>> widest, longest;

	for (size_t i = 0; i < vec.size(); i++) {
		widest.insert({ vec[i].first, i });
		longest.insert({ vec[i].second, i });

		blocks[i] = vec[i];
	}

	pair<ll, ll> ans = { -1, -1 };
	bool mode = 0;
	ll prevw = INF, prevh = INF, prv = -1;
	bool cringe = 0;
	while (widest.size() != 0) {
		if (mode == 0) {
			ll cur = (*widest.rbegin()).first, sum = 0;
			if (ans.second == -1) ans.second = cur;
			prv = blocks[(*widest.rbegin()).second].second;

			while (widest.size() > 0 && (*widest.rbegin()).first == cur) {
				auto it = (--widest.end());
				longest.erase({blocks[it->second].second, it->second });
				sum += blocks[it->second].second;
				widest.erase(it);
			}

			if (!cringe) ans.first = sum;
			prv = sum;
			if (prevw == INF) {
				prevh = cur;
			} else {
				prevw -= sum;
				if (prevh != cur) return { -1, -1 };
			}
		} else {
			ll cur = (*longest.rbegin()).first, sum = 0;
			if (!cringe) {
				ans.first = cur + prv;
				cringe = 1;
			}

			while (longest.size() > 0 && (*longest.rbegin()).first == cur) {
				auto it = (--longest.end());
				widest.erase({ blocks[it->second].first, it->second });
				sum += blocks[it->second].first;
				longest.erase(it);
			}

			if (prevw == INF) {
				prevw = cur;
				prevh -= sum;
				if (prevw != cur) return { -1, -1 };
			} else {
				prevh -= sum;
				if (prevw != cur) return { -1, -1 };
			}
		}

		mode ^= 1;
	}

	if (prevh == 0 || prevw == 0 || prevh == INF || prevw == INF) {
		return ans;
	} else {
		return { -1, -1 };
	}
}

signed main() {
	fastInp;

    ll t;
    cin >> t;
    
    while (t--) {
        vec.clear();
        blocks.clear();
    	cin >> n;
    
    	vec.resize(n);
    	for (auto& c : vec) cin >> c.first >> c.second;
    
    	vector<pair<ll, ll>> ans;
    
    	ans.push_back(solve());
        
    	swap(ans.back().first, ans.back().second);
    	if (ans.back().first == -1) ans.pop_back();
    
    	for (auto& c : vec) swap(c.first, c.second);
    
    	ans.push_back(solve());
    	if (ans.back().first == -1) ans.pop_back();
    
    	if (ans.size() == 2 && ans[0] == ans[1]) {
    		ans.pop_back();
    	}
    	cout << ans.size() << "\n";
    
    	for (auto c : ans) cout << c.first << " " << c.second << "\n";
    }
    
	return 0;
}