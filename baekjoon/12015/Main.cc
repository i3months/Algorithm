#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int n;
int arr[1000001];
int lis[1000001];
int dp[1000001] = {0,};
int len = 1;
string ans;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);
	
	cin >> n;

	for(int i=0; i<n; i++) cin >> arr[i];

	lis[0] = arr[0];

	for(int i=1; i<n; i++) {
		int cur = arr[i];

		if(lis[len-1] < cur) {
			len++; lis[len-1] = cur;
		} else {
			int start = 0;
			int fin = len;

			while(start < fin) {
				int mid = (start + fin) / 2;

				if(lis[mid] < cur) start = mid + 1;
				else fin = mid;
			}

			lis[start] = cur;
		}

	}

	cout << lis[0] << " ";
	for(int i=1; i<n; i++) {		
		if(lis[i-1] > lis[i]) continue;
		if(lis[i] == 0) continue;
		cout << lis[i] << " ";
	}
	cout << endl;

	cout << len << endl;

}