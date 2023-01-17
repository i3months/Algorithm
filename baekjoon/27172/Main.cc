#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int n;
	cin >> n;

	vector<int> vec(n);
	vector<int> ans(n, 0);

	map<int, int> m;

	for(int i=0; i<n; i++) {
		cin >> vec[i]; m[vec[i]] = i;
	}

	sort(vec.begin(), vec.end());

	for(int i=0; i<n; i++) {		
		for(int j=1; j<(int)sqrt(vec[i])+1; j++) {
			if(vec[i] % j != 0) continue;
			int first = j;
			int second = vec[i] / j;
			if(m.count(first))  {
				ans[m[vec[i]]]--;
				ans[m[first]]++;
			}
			if( second != first && m.count(second)) {
				ans[m[vec[i]]]--;
				ans[m[second]]++;
			}
		}
	}

	for(int i=0; i<n; i++) cout << ans[i] << " ";
	cout << endl;

}

