#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int n, m, l;
vector<int> vec;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m >> l;
	vec.push_back(0); vec.push_back(l);
	for(int i=0; i<n; i++) {
		int aa; cin >> aa; vec.push_back(aa);
	}	
	sort(vec.begin(), vec.end());

	int start = 1;
	int end = l-1;
	int res = 0;

	while(start <= end) {
		int mid = (start + end) / 2;

		int restNum = 0;

		for(int i=1; i<vec.size(); i++) {
			int dist = vec[i] - vec[i-1];
			// if(mid == 0) continue;
			restNum += (dist / mid);

			if(dist % mid == 0) restNum--;
		}

		if(restNum > m) {
			start = mid + 1;
		} else {
			end = mid - 1;
			res = mid;
		}
	}

	cout << res << endl;


}