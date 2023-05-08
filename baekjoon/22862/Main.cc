#include <bits/stdc++.h>
#define endl "\n"

typedef long long ll;
using namespace std;

const int N = 1e7+10;
const int INF = 987654321;
const ll INF2 = 10000000001;

ll n, k, ans = 0, cnt = 0;
ll arr[N];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> k;

	for(int i=0; i<n; i++) cin >> arr[i];

	int left = 0;
	int right = 0;

	while(1) {
		if(right == n) break;

		if(cnt > k) {
			if(arr[left] % 2 == 1) cnt--;
			left++;
		} else {
			if(arr[right] % 2 == 1) cnt++;
			right++;
		}		

		if(cnt <= k) ans = max(ans, right-left-cnt);

	}



	cout << ans << endl;

}