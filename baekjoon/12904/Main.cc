#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

string s, t;
bool flag = false;

void solve(string ss) {
	if(ss == t) {
		cout << 1 << endl;
		flag = true;
		return;
	}

	if(ss.length() > t.length()) {
		return;
	}
	
	solve(ss + "A");
	string revStr = ss;
	reverse(revStr.begin(), revStr.end());
	solve(revStr + "B");		
}

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> s >> t;

	// solve(s);
	// if(!flag) cout << 0 << endl;

	while(true) {
		if(s.length() == t.length()) {
			if(s == t) flag = true;
			break;
		}

		if(t[t.length()-1] == 'A') {
			t.pop_back();
		} else {
			t.pop_back();
			reverse(t.begin(), t.end());
		}
	}

	cout << flag << endl;
	
}

