#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 100000000001;

typedef long long ll;
using namespace std;

int n, m;
int arr[1000001];

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> n >> m;

	if(n <= m) {
		cout << n << endl;
		return;
	}

	for(int i=1; i<m+1; i++) cin >> arr[i];

	ll left = 0;
	ll right = INF2;
	ll ans = 0;
	
	while(left <= right) {
		ll mid = (left + right) / 2;
		ll riding = m;

		for(int i=1; i<m+1; i++) riding += (mid / arr[i]);

		if(riding >= n) {
			right = mid-1;
			ans = mid;
		} else {
			left = mid + 1;
		}
	}

	ll target = m;
	for(int i=1; i<m+1; i++) target += ((ans-1) / arr[i]);
	
	for(int i=1; i<m+1; i++) {
		if(ans % arr[i] == 0) target++;

		if(target == n) {
			cout << i << endl;
			return;
		}
	}
	
}