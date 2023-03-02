#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int n;
int arr[100002];

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> n;


	for(int i=0; i<n; i++) {
		cin >> arr[i];		
	}

	sort(arr, arr+n);

	ll ans = 0;	
	ll decr = 0;

	for(int i=0; i<n; i++) {
		if(arr[i] <= decr) continue;

		decr++;

		if(decr < arr[i]) ans += (arr[i] - decr);
	}

	cout << ans << endl;

	
	
	
}