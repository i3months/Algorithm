#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int n;
	cin >> n;

	vector<int> vec1(n);
	vector<int> vec2(n);
	
	for(int i=0; i<n; i++) {
		cin >> vec1[i];
		if(vec1[i] == 1) {
			vec1[i] = 1;
			vec2[i] = -1;
		} else {
			vec1[i] = -1;
			vec2[i] = 1;
		}		
	}

	int ans = 0;

	int val1 = 0;
	for(int i=0; i<n; i++) {
		val1 += vec1[i];
		if(val1 == -1) val1 = 0;
		
		ans = max(ans, val1);
	}

	int val2 = 0;
	for(int i=0; i<n; i++) {
		val2 += vec2[i];
		if(val2 == -1) val2 = 0;

		ans = max(ans, val2);
	}

	cout << ans << endl;
}

