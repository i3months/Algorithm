#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int n, k, ans = 0;
	cin >> n >> k;

	vector<int> sequence(101,0);
	vector<int> cur(101,0);

	for(int i=0; i<k; i++) cin >> sequence[i];

	for(int i=0; i<k; i++) {
		bool flag = false;

		// already in
		for(int j=0; j<n; j++) {
			if(cur[j] == sequence[i]) {
				flag = true;
				break;
			}
		}

		if(flag) continue;

		// empty
		for(int j=0; j<n; j++) {
			if(!cur[j]) {
				cur[j] = sequence[i];
				flag = true;
				break;
			}
		}

		if(flag) continue;

		// need to pick
		int remove = -1;
		int last = -1;

		for(int j=0; j<n; j++) {
			int tmp = 0;
			for(int a=i+1; a<k; a++) {
				if(sequence[a] == cur[j]) break;				
				tmp++;
			}

			if(tmp > last) {
				last = tmp;
				remove = j;
			}
		}

		cur[remove] = sequence[i];
		ans++;
		
	}

	cout << ans << endl;
}

