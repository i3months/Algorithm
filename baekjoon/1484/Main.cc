#include <bits/stdc++.h>
#define endl "\n"

typedef long long ll;
using namespace std;

const int N = 1e7+10;
const int INF = 987654321;
const int INF2 = 1000000001;

ll n;

void solve() {
	ll left = 1;
	ll right = 1;

	bool flag = false;

	while(1) {
		ll l = left * left;
		ll r = right * right;

		if(r - l == n) {
			cout << left << endl;
			flag = true;
		}
		if(right - left == 1 && r - l > n) break;
		if(r - l > n) left++;
		else right++;
	}

	if(!flag) cout << - 1 << endl;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;	
	solve();

}