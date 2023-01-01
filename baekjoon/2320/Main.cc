#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <memory.h>

using namespace std;
typedef long long ll;

int N;
int dp[1<<17][30];
vector<string> vec;

int solve(int visit, int idx) {
	int& ret = dp[visit][idx];
	if(ret != -1) return ret;

	int lastchar = vec[idx][vec[idx].size()-1] - 'A';
	// word[word.size()-1] - 'A';	
	ret = 0;

	for(int i=0; i<N; i++) {
		int firstchar = vec[i][0] - 'A';

		if(lastchar != firstchar) continue;
		if(visit & (1 << i)) continue;

		int next = visit | (1 << i);				

		ret = max(ret, solve(next, i) + (int)vec[i].size());
	}

	return ret;
}

int main() {
	// cin.tie(0)->sync_with_stdio(0);

	cin >> N;
	
	for(int i=0; i<N; i++) {
		string str;
		cin >> str;

		vec.push_back(str);		
	}

	// memset(dp, -1, sizeof(dp));

	int ans = 0;
	for(int i=0; i<N; i++) {
		memset(dp, -1, sizeof(dp));
		ans = max(ans, solve(1<<i, i) + (int)vec[i].size());
	}

	cout << ans << endl;
	

}

