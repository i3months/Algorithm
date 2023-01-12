#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int TC;
	cin >> TC;

	while(TC-- > 0) {		
		ll n, m, x;
		cin >> n >> x;
		m = n;
		while(n > x) {
			m = n + (n & -n);
			n = n & m;
		}

		if(n < x) m = -1;

		cout << m << endl;


	}
}