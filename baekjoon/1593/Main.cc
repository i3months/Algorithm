#include <bits/stdc++.h>
#define endl "\n"
// #define inf INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

const int N = 1e7+10;
const int INF = 987654321;

deque<char> dq;
int n, m, ans = 0;
string w, s;
unordered_map<char, int> mp1;
unordered_map<char, int> mp2;

void solve() {
	for(auto[k, v] : mp1) {
		if(mp2[k] != v) return;			
	}	
	ans++;
	return;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m >> w >> s;

	for(int i=0; i<w.size(); i++) {
		mp1[w[i]]++;
		mp2[s[i]]++;
		dq.push_back(s[i]);
	}

	for(int i=w.size(); i<s.size(); i++) {
		solve();		
		
		mp2[dq.front()]--;
		dq.pop_front();		

		mp2[s[i]]++;
		dq.push_back(s[i]);				

		// for(char k : dq) {
		// 	cout << k;		
		// }
		// cout << endl;
	}

	solve();

	cout << ans << endl;
	

	
}