#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int G, P;
const int limit = 100001;
int parent[limit];

int find(int u) {
	if(u == parent[u]) return u;
	return parent[u] = find(parent[u]);
}

void merge(int u, int v) {
	u = find(u);
	v = find(v);

	parent[u] = v;		
}

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> G >> P;

	int ans = 0;

	for(int i=0; i<G+1; i++) parent[i] = i;

	for(int i=0; i<P; i++) {
		int n;
		cin >> n;

		int dock = find(n);

		if(dock == 0) break;
		
		merge(dock, dock - 1);
		ans++;				
	}

	cout << ans << endl;
}

