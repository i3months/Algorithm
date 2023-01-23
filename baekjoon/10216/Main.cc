#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

struct Node {
	int x, y, r;
};

int parent[3001];

int find(int x) {
	if (parent[x] == x) return x;
	return parent[x] = find(parent[x]);
}

void merge(int x, int y) {
	x = find(x);
	y = find(y);

	if(x == y) return;
	
	parent[x] = y;

}

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int TC;
	cin >> TC;

	while(TC--) {
		int n, x, y, r;
		cin >> n;

		vector<Node> v;

		for(int i=0; i<n; i++) {
			parent[i] = i;			
			cin >> x >> y >> r;

			Node nde;
			nde.x = x; nde.y = y; nde.r = r;

			v.push_back(nde);				
		}

		int ans = n;

		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				int x1 = v[i].x; int y1 = v[i].y; int r1 = v[i].r;
				int x2 = v[j].x; int y2 = v[j].y; int r2 = v[j].r;

				ll dist1 = pow(r2+r1, 2);
				ll dist2 = pow(x2-x1, 2) + pow(y2-y1, 2);

				if(dist1 >= dist2 && find(i) != find(j)) {
					ans--;
					merge(i, j);
				}

				
			}
		}

		cout << ans << endl;

	}

}

