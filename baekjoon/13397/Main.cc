#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int n, m, res = 100000;
int arr[5001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;
	int ttt = -1;
	
	for(int i=0; i<n; i++) {
		cin >> arr[i];
		ttt = max(ttt, arr[i]);
	}

	int left = 0;
	int right = ttt;

	while(left <= right) {
		int mid = (left + right) / 2;
		
		int cnt = 1;
		int minValue = arr[0];
		int maxValue = arr[0];

		for(int i=1; i<n; i++) {
			if(arr[i] < minValue) minValue = arr[i];
			if(arr[i] > maxValue) maxValue = arr[i];

			if((maxValue - minValue) > mid) {
				cnt++;
				minValue = arr[i]; maxValue = arr[i];
			}
		}

		if(cnt <= m) {
			right = mid - 1;
			// if(res > mid) res = mid;
			res = min(mid, res);
		} else {
			left = mid + 1;
		}
	}
	
	cout << res << endl;

}