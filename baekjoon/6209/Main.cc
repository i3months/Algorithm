#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int d, n, m;
vector<int> v;
vector<int> v2;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> d >> n >> m;

	v.resize(n+2);
	
	v[0] = 0;
	for(int i=1; i<n+1; i++) cin >> v[i];				
	v[n+1] = d;
	sort(v.begin(), v.end());

	int left = 0;
	int right = INF;
	int ans = -1;

	while(left <= right) {
		int mid = (left + right) / 2;
		
		int cnt = 0;
		int cur = 0;

		for(int i=1; i<n+2; i++) {
			if(v[i] - v[cur] < mid) {
				cnt++;
			} else {
				cur = i;
			}			
		}

		if(cnt > m) {
			right = mid - 1;
		} else {
			ans = mid;
			left = mid + 1;
		}

	}

	cout << ans << endl;
	
	

}