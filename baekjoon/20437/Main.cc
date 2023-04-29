#include <bits/stdc++.h>
#define endl "\n"
// #define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

const int N = 1e7+10;
const int INF = 987654321;

int TC, k;
string w;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> TC;

	while(TC--) {
		cin >> w >> k;

		vector<vector<int>> v;

		for(int i=0; i<26; i++) {
			vector<int> v1;
			v.push_back(v1);
		}

		for(int i=0; i<w.length(); i++) {
			int n = w[i] - 'a';
			v[n].push_back(i);
		}

		int minValue = INF;
		int maxValue = -1;

		for(int i=0; i<26; i++) {
			int len = v[i].size();
			if(len >= k) {
				for(int j=0; j<len-k+1; j++) {
					minValue = min(minValue, v[i][j+k-1] - v[i][j]+1);
					maxValue = max(maxValue, v[i][j+k-1] - v[i][j]+1);
				}
			}
		}

		if(minValue == INF || maxValue == -1) {
			cout << -1 << endl;
		} else {
			cout << minValue << " " << maxValue << endl;
		}
	}
	
	
}