#include <bits/stdc++.h>
#define endl "\n"

using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int TC;
	cin >> TC;

	while(TC-- > 0) {		
		int n; cin >> n;

		vector<vector<int>> v;

		map<int, int> mp;

		for(int i=0; i<n; i++) {
			int k; cin >> k;
			v.push_back(vector<int>(k));

			for(int j=0; j<k; j++) {
				int a; cin >> a;
				mp[a]++;
				v[i][j] = a;
			}
		}

		bool isAble = 0;
		for(int i=0; i<n; i++) {
			bool chk = 1;
			for(auto k : v[i]) {
				int nn = mp[k] > 1 ? 1 : 0;
				chk &= nn;
			}

			if(chk) isAble = 1;
		}

		if(isAble) cout << "Yes" << endl;
		else cout << "No" << endl;

	}
}