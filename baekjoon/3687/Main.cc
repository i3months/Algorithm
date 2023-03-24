#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;

typedef long long ll;
using namespace std;

ll dp[101];

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int TC;

	cin >> TC;

	int arr[9] = { 0, 0, 1, 7, 4, 2, 0, 8, 10 };

	for(int i=1; i<9; i++) dp[i] = arr[i];
	dp[6] = 6;

	for(int i=9; i<101; i++) {
		dp[i] = (dp[i-2]*10) + arr[2];
		for(int j=3; j<8; j++) {
			dp[i] = min(dp[i], dp[i-j]*10 + arr[j]);
		}
	}	

	while(TC-- > 0) {
		int n;
		cin >> n;

		cout << dp[n] << " ";

		if(n % 2 == 0) {
			for(int i=0; i<n/2; i++) cout << 1;
		} else {
			cout << 7;
			for(int i=0; i<n/2 - 1; i++) cout << 1;
		}	

		cout << endl;
	}


}