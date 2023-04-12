#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int l, k, c;
vector<int> v;
vector<int> len;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> l >> k >> c;

	v.resize(k+1);
	len.resize(k+1);

	for(int i=0; i<k; i++) cin >> v[i];
	v[k] = l;

	sort(v.begin(), v.end());

	len[0] = v[0];

	for(int i=1; i<k+1; i++) len[i] = v[i] - v[i-1];

	int left = 0;
	int right = 1000000000;

	int ans1 = -1;
	int ans2 = -1;


	while(left <= right) {
		int mid = (left + right) / 2;

		int cut = 0;
		int idx = 0;
		int start = 0;
		
		for(int i=k; i>=0; i--) {
			if(len[i] > mid) {
				cut = INF;
				break;
			}

			if(start + len[i] > mid) {
				start = 0;
				cut++;
				idx = i;
			}

			start += len[i];
		}

		if(cut > c) {
			left = mid + 1;
		} else {
			right = mid - 1;
			ans1 = mid;
			ans2 = (cut == c) ? v[idx] : v[0];
		}
	}

	cout << ans1 << " " << ans2 << endl;

	 
	

}