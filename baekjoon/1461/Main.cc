#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int n, m, ans = 0;
vector<int> v;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> n >> m;

	for(int i=0; i<n; i++) {
		int q;
		cin >> q;
		v.push_back(q);
	}

	sort(v.begin(), v.end());

	int idx = 0;

	for(int i=0; i<n; i++) {
		if(v[i] < 0) {
			idx++;
		}
	}	

	for(int i=0; i<idx; i+=m) {
		ans += abs(v[i] * 2);
	}

	for(int i=n-1; i>=idx; i-=m) {
		ans += abs(v[i] * 2);
	}

	ans -= max(abs(v[0]), abs(v[n-1]));

	cout << ans << endl;

	
	
}

