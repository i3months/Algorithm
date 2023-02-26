#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

ll arr[100001];
ll sum[100001];
int n;
ll ans = -1;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> n;

	sum[0] = 0;	

	for(int i=1; i<n+1; i++) {
		cin >> arr[i];
		sum[i] = arr[i] + sum[i-1];
	}	

	for(int i=2; i<n; i++) ans = max(ans, sum[n] - arr[1] - arr[i] + sum[n] - sum[i]);
	for(int i=2; i<n; i++) ans = max(ans, sum[n] - arr[n] - arr[i] + sum[i-1]);
	for(int i=2; i<n; i++) ans = max(ans, sum[i] - arr[1] + sum[n] - sum[i-1] - arr[n]);

	cout << ans << endl;	
	
	
}