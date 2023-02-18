#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

ll TC, n, s, t, ans;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> TC;

	while(TC-- > 0) {
		cin >> n >> s >> t;

		if(n == 1) {
			cout << s << endl;
			continue;
		}

		ll quo = t / s;
		ll divi = t % s;		

		if(divi) quo++;

		ans = s;

		while(n != 2) {
			ll val = n / 2;

			if(n % 2) { // 홀수
				ans += s;
				n--;
			} else { // 짝수 
				if(val >= quo) ans += t;
				else ans += (s * val);

				n = n / 2;
			}
		}

		if(s < t) cout << ans + s << endl;
		else cout << ans + t << endl;
	}
	
}

