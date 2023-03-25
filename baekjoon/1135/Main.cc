#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;

typedef long long ll;
using namespace std;

vector<vector<int>> v;
int n;

int dfs(int idx) {
	if(v[idx].empty()) return 0;

	vector<int> v2;

	for(int k : v[idx]) v2.push_back(dfs(k));

	sort(v2.begin(), v2.end(), greater());

	int ret = 0;
	for(int i=0; i<v2.size(); i++) ret = max(ret, v2[i] + (i+1));

	return ret;	
}

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> n;
	v.resize(n+1);

	int cur;
	cin >> cur;

	for(int i=1; i<n; i++) {
		cin >> cur;
		v[cur].push_back(i);	
	}

	cout << dfs(0) << endl;
	

}