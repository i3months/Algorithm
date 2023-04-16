#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int n, t;
vector<pair<int, int>> v;
int visited[50002];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> t;

	v.push_back(make_pair(0, 0));

	for(int i=0; i<n; i++) {
		int a, b; cin >> a >> b;
		v.push_back(make_pair(a, b));
	}

	sort(v.begin(), v.end());

	queue<int> q;
	q.push(0);
	visited[0] = 1;

	while(!q.empty()) {
		int cur = q.front(); q.pop();		
		
		if(v[cur].second == t) {
			cout << visited[cur] - 1 << endl;
			return 0;
		}

		for(int i=cur+1; i<n+1; i++) {
			if(abs(v[i].first - v[cur].first) > 2) break;
			if(visited[i] == 0 && abs(v[i].second - v[cur].second) <= 2) {
				visited[i] = visited[cur] + 1; q.push(i);
			} 
		}

		for(int i=cur-1; i>0; i--) {
			if(abs(v[i].first - v[cur].first) > 2) break;
			if(visited[i] == 0 && abs(v[i].second - v[cur].second) <= 2) {
				visited[i] = visited[cur] + 1; q.push(i);
			} 
		}		
		
	}


	cout << -1 << endl;
		

}