#include <bits/stdc++.h>
#define endl "\n"

typedef long long ll;
using namespace std;

const int N = 1e7+10;
const int INF = 987654321;
const ll INF2 = 10000000001;

ll n, m, res = INF2;
vector<ll> v[1001];
priority_queue<pair<ll, pair<ll, ll>>> pq;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;

	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			ll val; cin >> val;
			v[i].push_back(val);
		}
	}

	ll minValue = INF2;		

	for(int i=0; i<n; i++) {
		sort(v[i].begin(), v[i].end(), greater<ll>());
		pq.push({v[i][0], {i,0}});
		minValue = min(minValue, v[i][0]);		
	}

	while(pq.size()) {
		ll maxValue = pq.top().first;
		ll maxClassIdx = pq.top().second.first;
		ll maxClassStudentIdx = pq.top().second.second;

		pq.pop();

		res = min(res, maxValue - minValue);

		if(maxClassStudentIdx + 1 == m) break;

		minValue = min(minValue, v[maxClassIdx][maxClassStudentIdx+1]);
		pq.push({v[maxClassIdx][maxClassStudentIdx+1], {maxClassIdx, maxClassStudentIdx+1}});
	}
	

	cout << res << endl;

}