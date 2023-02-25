#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int n, cnt, ans = 987654321;
string start, dest;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);	

	cin >> n >> start >> dest;

	string s1;	
	
	// press first
	s1 = start;
	cnt = 0;
	s1[0] = s1[0] == '0' ? '1' : '0';
	s1[1] = s1[1] == '0' ? '1' : '0';
	cnt++;

	for(int i=1; i<n; i++) {
		if(s1[i-1] != dest[i-1]) {
			s1[i] = s1[i] == '0' ? '1' : '0';
			s1[i-1] = s1[i-1] == '0' ? '1' : '0';
			if(i != n-1) s1[i+1] = s1[i+1] == '0' ? '1' : '0';
			cnt++;
		}
	}

	if(s1 == dest) ans = min(ans, cnt);

	// not press first
	s1 = start;
	cnt = 0;			
	for(int i=1; i<n; i++) {
		if(s1[i-1] != dest[i-1]) {
			s1[i] = s1[i] == '0' ? '1' : '0';
			s1[i-1] = s1[i-1] == '0' ? '1' : '0';
			if(i != n-1) s1[i+1] = s1[i+1] == '0' ? '1' : '0';
			cnt++;
		}
	}

	if(s1 == dest) ans = min(ans, cnt);
	
	if(ans == 987654321) cout << -1 << endl;
	else cout << ans << endl;
	
		
}