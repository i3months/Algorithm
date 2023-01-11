#include <bits/stdc++.h>
#define endl "\n"

using namespace std;

const int N = 200005;
int n;
int a[N], b[N], c[N], ra[N], rb[N];
int visit1[N];
int visit2[N];		
int res[N];


int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int TC;
	cin >> TC;

	while(TC-- > 0) {		
		cin >> n;		

		vector<pair<int, int>> vec;

		for(int i=0; i<n; i++) {
			cin >> c[i];
			a[i] = b[i] = 0;
			res[i] = 0;
			visit1[i] = visit2[i] = 0;
			visit1[i+1] = visit2[i+1] = 0;

			ra[i+1] = rb[i+1] = 1;
			vec.push_back({c[i], i});
		}

		sort(vec.rbegin(), vec.rend());

		for(int i=0; i<n; i++) {
			int val = vec[i].first;
			if(visit1[val] == 0) a[i] = val;	
			visit1[val] = 1;							
		}

		for(int i=0; i<n; i++) {
			if(a[i] != 0) continue;
			int val = vec[i].first;
			if(visit2[val] == 0) b[i] = val;
			visit2[val] = 1;
		}

		// for(int i=0; i<n; i++) {
		// 	cout << a[i] << " ";
		// }

		// cout << endl;

		// for(int i=0; i<n; i++) {
		// 	cout << b[i] << " ";
		// }

		for(int i=0; i<n; i++) {
			if(a[i] != 0) continue;
			for(int j=n; j>=1; j--) {
				if(visit1[j] == 1) continue;
				a[i] = j;
				visit1[j] = 1;
				break;
			}
		}

		for(int i=0; i<n; i++) {
			if(b[i] != 0) continue;
			for(int j=n; j>=1; j--) {
				if(visit2[j] == 1) continue;
				b[i] = j;
				visit2[j] = 1;
				break;
			}
		}		

		for(int i=0; i<n; i++) {
			res[i] = max(a[i], b[i]);
		}

		bool chk = false;
		for(int i=0; i<n; i++) {
			if(res[i] != vec[i].first) {
				chk = true;
				cout << "NO" << endl;
				break;
			}
		}
		if(chk == true) continue;	

		int ii = 0;	

		cout << "YES" << endl;

		while(true) {			
			for(int i=0; i<n; i++) {
				int idx = vec[i].second;
				if(idx == ii) {
					cout << a[i] << " ";
					ii++;
					break;
				}
			}

			if(ii == n) break;
		}

		cout << endl;

		ii = 0;

		while(true) {
			for(int i=0; i<n; i++) {
				int idx = vec[i].second;
				if(idx == ii) {
					cout << b[i] << " ";
					ii++;
					break;
				}
			}
			
			if(ii == n) break;
		}

		cout << endl;



		// for(int i=0; i<n; i++) {
		// 	cout << a[i] << " ";
		// }

		// cout << endl;

		// for(int i=0; i<n; i++) {
		// 	cout << b[i] << " ";
		// }

		// cout << endl;

		// for(int i=0; i<n; i++) {
		// 	cout << res[i] << " ";
		// }
		

	}
}