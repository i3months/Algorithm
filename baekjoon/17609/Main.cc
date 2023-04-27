#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

const int N = 1e7+10;

int n;

int solve(int left, int right, int cnt, string s) {
	while(left < right) {
		if(s[left] != s[right]) {
			if(cnt == 0) {
				if(solve(left+1, right, 1, s) == 0 || solve(left, right-1, 1, s) == 0) {
					return 1;					
				}
				return 2;
			} else {
				return 2;
			}
		} else {
			left++; right--;
		}
	}
	return 0;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	while(n--) {
		string s;		
		cin >> s;

		int len = s.length()-1;

		cout << solve(0, len, 0, s) << endl;

	}

		
	
}