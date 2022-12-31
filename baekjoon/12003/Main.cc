#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef long long ll;

int main() {
	cin.tie(0)->sync_with_stdio(0);

	int N, K;
	cin >> N >> K;

	vector<int> vec;
	vector<int> dp(N, 0);
	vector<int> dp2(N+1, 0);

	for(int i=0; i<N; i++) {
		int a;
		cin >> a;	
		vec.push_back(a);
	}

	sort(vec.begin(), vec.end());
	
	int idx = 0;

	for(int i=0; i<N; i++) {
		while(idx < N && vec[idx] - vec[i] <= K) idx++;
		dp[i] = idx - i;
	}

	for(int i=N-1; i>=0; i--) {
		dp2[i] = max(dp2[i+1], dp[i]);
	}

	int ans = 0;
	for(int i=0; i<N; i++) {
		ans = max(ans, dp[i] + dp2[i + dp[i]]);
	}
	
	cout << ans << endl;


}