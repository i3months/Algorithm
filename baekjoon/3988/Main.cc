#include <bits/stdc++.h>
#define endl "\n"

typedef long long ll;
using namespace std;

const int N = 1e7+10;
const int INF = 987654321;
const int INF2 = 1000000001;

ll n, k;
deque<ll> dq;
ll arr[N];
ll res = INF;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> k;

	for(int i=0; i<n; i++) cin >> arr[i];
	sort(arr, arr+n);

	k = n-k;	

	int idx = 1;

	for(int i=0; i+k<n+1; i++) {
		if(!dq.empty() && dq.front() <= i) {
			dq.pop_front();
		}

		while(idx < i+k) {		
			while(!dq.empty() && arr[idx]-arr[idx-1] <= arr[dq.back()] - arr[dq.back()-1]) {
				dq.pop_back();
			}

			dq.push_back(idx);
			idx++;
		}

		ll m = arr[dq.front()] - arr[dq.front()-1];
		ll M = arr[i+k-1] - arr[i];
		res = min(res, m+M);
		
	}

	cout << res << endl;

}