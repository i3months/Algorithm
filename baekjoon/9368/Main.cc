	#include <iostream>
	#include <algorithm>
	#include <string>
	#include <vector>
	#include <memory.h>
	#include <cmath>

	using namespace std;
	typedef long long ll;

	int N, C, M;
	int member[17][2];
	double dp[1<<17][17];

	double solve(int status, int hire) {
		double& ret = dp[status][hire];
		if(ret >= 0) return ret;
		if(hire == 0) return ret = 1;

		int spare = M;
		int cnt = N;

		for(int i=0; i<N; i++) {
			if(status & (1 << i)) {
				spare -= member[i][0];
				cnt--;	
			}
		}

		if(cnt < hire) return ret = 0;

		ret = 0;

		for(int i=0; i<N; i++) {
			if(status & (1 << i)) continue;
			if(spare < member[i][0]) continue;

			double num1 = solve(status | (1 << i), hire - 1) * member[i][1];
			double num2 = solve(status | (1 << i), hire) * (100 - member[i][1]);
			double cmp = (num1 + num2) / 100;

			ret = max(ret, cmp);							
		}

		return ret;
	}

	int main() {
		ios_base :: sync_with_stdio(false);
		cin.tie(NULL);
		cout.tie(NULL);
		
		int TC;

		cin >> TC;

		while(TC-- > 0) {
			cin >> N >> C >> M;

			memset(member, 0, sizeof(member));

			for (int i=0; i<N; i++) {
				int b, p;
				cin >> b >> p;
				
				member[i][0] = b;
				member[i][1] = p;
			}

			memset(dp, -1, sizeof(dp));

			cout << fixed;
			cout.precision(7);
			cout << solve(0, C) << endl;
		}

		
		
	}