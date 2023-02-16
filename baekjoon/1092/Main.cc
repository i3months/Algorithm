#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

vector<int> v1;
vector<int> v2;

int n, m, k;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> n;

	for(int i=0; i<n; i++) {		
		cin >> k; v1.push_back(k);
	}

	cin >> m;

	for(int i=0; i<m; i++) {		
		cin >> k; v2.push_back(k);		
	}

	sort(v1.begin(), v1.end(), greater<int>());
	sort(v2.begin(), v2.end(), greater<int>());

	if(v2[0] > v1[0]) {
		cout << -1 << endl;
		return 0;
	}

	int ans = 0;

	while(!v2.empty()) {
		ans++;
		for(int i=0; i<v1.size(); i++) {
			for(int j=0; j<v2.size(); j++) {
				if(v1[i] >= v2[j]) {
					v2.erase(v2.begin() + j); break;
				}
			}
		}	
	}
	
	cout << ans << endl;
	
}

