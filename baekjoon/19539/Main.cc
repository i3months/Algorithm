#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int n, s1 = 0, s2 = 0;

	cin >> n;

	for(int i=0; i<n; i++) {
		int a;
		cin >> a;
		s1 += a;
		s2 += (a / 2);
	}

	if(s1 % 3 != 0) {
		cout << "NO" << endl;
	} else {
		if(s2 >= (s1 / 3)) {
			cout << "YES" << endl;
		} else {
			cout << "NO" << endl;
		}
	}

	
}