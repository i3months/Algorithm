#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int c1, c2, n, m;
vector<int> v;
vector<int> p, q;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m >> c1 >> c2;

	int base = abs(c1 - c2);

	for(int i=0; i<n; i++) {
		int ta; 
		cin >> ta; p.push_back(ta);
	}

	for(int i=0; i<m; i++) {
		int ta;
		cin >> ta; q.push_back(ta);
	}

	int pdx = 0, qdx = 0, minVal = INF;
	int ans = -1, cnt = 0;

	sort(p.begin(), p.end()); sort(q.begin(), q.end());

	while(pdx < n && qdx < m) {
		int val = abs(q[pdx] - p[qdx]);
		if(minVal > val) {
			minVal = val;
			cnt = 1;
		} else if(minVal == val) {
			cnt++;
		}

		if(q[pdx] - p[qdx] > 0) {
			qdx++;
		} else {
			pdx++;
		}
		
	}

	cout << minVal + abs(c2 - c1) << " " << cnt << endl;
	

}