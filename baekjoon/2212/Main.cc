#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int n, k;

	cin >> n >> k;

	int arr[10001];

	for(int i=0; i<n; i++) cin >> arr[i];
	sort(arr, arr+n);
	
	int sumArr[10001];
	memset(sumArr, 0, sizeof(sumArr));

	for(int i=0; i<n-1; i++) sumArr[i] = arr[i+1] - arr[i];
	sort(sumArr, sumArr+n-1);

	int ans = 0;

	for(int i=0; i<n-k; i++) ans += sumArr[i];

	cout << ans << endl;
	
	
	
}

