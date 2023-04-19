#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int TC;
	cin >> TC;

	while(TC--) {
		int n;
		cin >> n;
		int a[200'001], mex;

		map<int, int> b, c;
		b.clear(); c.clear();

		for(int i=0; i<n; i++) {
			cin >> a[i]; b[a[i]]++;
		}

		for(mex=0; b[mex]; mex++);

		int left, right;
		left=n, right=-1;

		for(int i=0; i<n; i++) {
			if(a[i] == mex+1) {
				left = min(left, i);
				right = max(i, right);
			}
		} 

		for(int i=left; i<right+1; i++) c[a[i]]++;

		int ans = mex < n;

		for(int i=0; i<mex; i++) {
			if(c[i] == b[i]) ans = 0;
		}

		cout << (ans ? "YES" : "NO") << endl;
		
	}
}