#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int n, arr[1000001];
	memset(arr, 0, sizeof(arr));

	cin >> n;

	int cnt = 0;

	for(int i=0; i<n; i++) {
		int k;
		cin >> k;

		if(arr[k+1] == 0) {
			arr[k]++;
			cnt++;
			continue;
		}
	
		arr[k+1]--;
		arr[k]++;
	}

	cout << cnt << endl;
	
}