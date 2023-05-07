#include <bits/stdc++.h>
#define endl "\n"

typedef long long ll;
using namespace std;

const int N = 1e7+10;
const int INF = 987654321;
const ll INF2 = 10000000001;

ll n;
ll arr[N];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	sort(arr, arr+n);

	ll ans = INF2;

	for(int i=0; i<n; i++) {
		for(int j=i+1; j<n; j++) {
			ll snow1 = arr[i] + arr[j];
			int left = 0;
			int right = n-1;

			while(left < right) {
				if(left == i || left == j) {
					left++;
					continue;
				}

				if(right == i || right == j) {
					right--;
					continue;
				}
				
				ll snow2 = arr[left] + arr[right];
				ans = min(ans, abs(snow1-snow2));
				
				if(snow1 > snow2) left++;
				else right--;
			}
		}
	}

	cout << ans << endl;

}