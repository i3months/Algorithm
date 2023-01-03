#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <memory.h>
#include <cmath>

using namespace std;
typedef long long ll;
const int INF = 987654321;

string str;
int dp[1<<19][19];
int N;

int calc(int num) {
	if(num >= 13) num = 26 - num;
	return num;
}

int solve(int status, int cur) {
	if(status == (1<<N) - 1) return 0;

	int& ret = dp[status][cur];
	if(ret != -1) return ret;

	// ret = 0x7FFFFFFF;
	ret = INF;

	if(status == 0) {
		for(int i=0; i<N; i++) {
			int cnt = calc(str[i] - 'A');
			ret = min(ret, solve(1 << i, i) + 1 + cnt);
		}
	} else {
		for(int i=0; i<N; i++) {
			if((status & (1 << i)) != 0) continue;
			int cnt = abs(str[i] - str[cur]);
			cnt = calc(cnt);

			int move = 0;

			if(i < cur) {
				move++;
				for(int j=i+1; j<cur; j++) {
					if((status & (1 << j)) != 0) {
						move++;
					}
				}
			} else {
				for(int j=cur+1; j<i; j++) {
					if((status & (1 << j)) != 0) {
						move++;
					}
				}
			}

			ret = min(ret, solve(status | (1 << i), i) + cnt + 1 + move);

		}
	}	

	return ret;
}

int main() {
	cin.tie(0)->sync_with_stdio(0);

	while(1) {
		cin >> str;		
		N = str.size();
		if(str[0] == '0') break;
		memset(dp, -1, sizeof(dp));		
		cout << solve(0, 0) << endl;
	}	
}

