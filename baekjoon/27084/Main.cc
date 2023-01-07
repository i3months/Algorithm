#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <memory.h>
#include <cmath>

using namespace std;
typedef long long ll;
const int MOD = 1000000007;

int N;
vector<ll> vec;

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> N;
	vec.assign(N+1, 0);

	for (int i=0; i<N; i++) {
		int num;
		cin >> num;
		vec[num]++;	
	}

	ll ans = 1;

	for (int i=1; i<N+1; i++) {
		if(vec[i] == 0) continue;
		ans = (ans * (vec[i] + 1)) % MOD;
	}

	cout << ans - 1 << endl;		
	

	
}