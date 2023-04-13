#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int TC, k, n;
int arr[5][1001];
vector<ll> v1;
vector<ll> v2;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> TC;

	while(TC-- > 0) {
		cin >> k >> n;

		int arr[5][100001];
		vector<ll> v1;
		vector<ll> v2;

		for(int i=0; i<4; i++) {
			for(int j=0; j<n; j++) {
				cin >> arr[i][j];
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ll ss = arr[0][i] + arr[1][j];
				v1.push_back(ss);
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ll ss = arr[2][i] + arr[3][j];
				v2.push_back(ss);
			}
		}	
		
		sort(v1.begin(), v1.end());
		sort(v2.begin(), v2.end());

		ll ans = v1[0] + v2[0];

		for(int i=0; i<v1.size(); i++) {
			ll target = v1[i] - k;

			int idx = lower_bound(v2.begin(), v2.end(), abs(target)) - v2.begin();
			
			for(int a=0; a<2; a++) {
				int idxx = idx - a;

				if(idxx >= 0 && idxx < v2.size()) {
					ll approximation = abs(k - ans);
					if(approximation > abs(k - (v1[i] + v2[idxx]))) {
						ans = v1[i] + v2[idxx];
					} else if(approximation ==  abs(k - (v1[i] + v2[idxx]))) {
						ans = min(ans, v1[i] + v2[idxx]);
					}
				}	
			}	

		}
		
		cout << ans << endl;
	}
	

}