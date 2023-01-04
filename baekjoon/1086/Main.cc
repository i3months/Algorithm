#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <memory.h>
#include <cmath>

using namespace std;
typedef long long ll;
const int INF = 987654321;

int N, K;
string s[15];
int d[15], rem[15], pp[51];

ll dp[1<<15][100];

ll gcd(ll p, ll q){
	while(q){
		ll r = p % q;
		p = q;
		q = r;
	}
	return p;
}

ll solve(int status, int num) {
	ll &ret = dp[status][num];
	if(ret != -1) return ret;
	if(status == (1 << N) - 1) return (num % K == 0);	

	ret = 0; 
	
	for(int i=0; i<N; i++) {
		if(status & (1 << i)) continue;
		ret += solve(status | (1 << i), (num * pp[d[i]] + rem[i]) % K);
	}

	return ret;
}


int main() {
	cin.tie(0)->sync_with_stdio(0);
	
	cin >> N;
	
	for(int i=0; i<N; i++) cin >> s[i];

	cin >> K;

	for(int i=0; i<N; i++) {
		d[i] = s[i].size();
		for(int j=0; s[i][j]; j++) {
			rem[i] = (rem[i] * 10 + s[i][j] - '0') % K;
		}
	}

	pp[0] = 1 % K;

	for(int i=1; i<51; i++) {
		pp[i] = pp[i-1] * 10 % K;
	}

	memset(dp, -1, sizeof(dp));

	ll p = solve(0, 0);

	ll q = 1;
	ll g = 0;

	if(p == 0) {
		cout << "0/1" << "\n";
	} else {
		for(int i=2; i<N+1; i++) q *= i;
		g = gcd(p, q);

		cout << p/g << "/" << q/g << "\n";		
	}

}

