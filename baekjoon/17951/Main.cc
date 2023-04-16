#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int n, m;
vector<int> v;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;
	v.resize(n);

	for(int i=0; i<n; i++) cin >> v[i];

	int left = 0;
	int right = INF;
	int ans = -1;

	while(left <= right) {
		int mid = (left + right) / 2;
		int sum = 0;
		int cnt = 0;

		for(int i=0; i<n; i++) {
			sum += v[i];
			if(sum >= mid) {
				cnt++;
				sum = 0;
			}
		}

		if(cnt >= m) {
			left = mid + 1;
		} else {
			right = mid - 1;
			ans = mid;
		}

		
	}
	
	cout << ans - 1<< endl;
	
	

}