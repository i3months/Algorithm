#include <bits/stdc++.h>
#define endl "\n"

typedef long long ll;
using namespace std;

const int N = 1e7+10;
const int INF = 987654321;
const ll INF2 = 10000000001;

int n;

vector<char> s;
vector<char> v;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for(int i=0; i<n; i++) {
		char c; cin >> c;
		s.push_back(c);
	}

	int left = 0;
	int right = n-1;

	while(left <= right) {
		if(s[left] < s[right]) {
			v.push_back(s[left]);
			left++;
		} else if(s[left] > s[right]) {
			v.push_back(s[right]);
			right--;
		} else {
			bool flag = false;

			int left2 = left+1;
			int right2 = right-1;

			while(left2 <= right2) {
				if(s[left2] < s[right2]) {
					flag = true;
					v.push_back(s[left]);
					left++;
					break;
				} else if(s[left2] > s[right2]) {
					flag = true;
					v.push_back(s[right]);
					right--;
					break;
				}
				left2++; right2--;
			}

			if(!flag) {
				v.push_back(s[left]);
				left++;
			} 
						
		}
	}

	for(int i=0; i<n; i++) {
		cout << v[i];
		if(i!=0 && (i+1) % 80 == 0) cout << endl;
	}


}