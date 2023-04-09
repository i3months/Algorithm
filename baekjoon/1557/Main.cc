#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

ll k;
bool visited[50001];
int sign[50001];
vector<int> primes;

ll solve(ll n) {
	ll ans = 0;
	for(int i=1; i*i<n+1; i++) {
		ans += (sign[i] * (n / (i*i)));
	}

	return ans;
}

void preperation() {
	sign[1] = 1;
	for(int i=1; i<50000; i++) {
		for(int j=i*2; j<50000; j+=i) {
			sign[j] -= sign[i];
		}
	}
}


void sieve(int n) {
    for (int i = 2; i < n; i++) {
        if (!visited[i]) 
            primes.push_back(i);
        for (int j = i+i; j < n; j+=i) {
            visited[j] = 1;
        }
    }
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	preperation();

	cin >> k;

	ll left = 1;
	ll right = 2000000000;
	ll ans = 2000000000;

	while(left <= right) {
		ll mid = (left + right) / 2; 
		// int mid = left +(right - left) / 2;

		if(solve(mid) < k) {
			left = mid + 1;
		} else {
			right = mid - 1;
			ans = mid;
		}
	}

	cout << ans << endl;	

}