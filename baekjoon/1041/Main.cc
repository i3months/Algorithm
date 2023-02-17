#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int n;
int dice[6];
int m3 = 999, m2 = 999, m1 = 999, mm = 0;
ll ans = 0;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> n;

	for(int i=0; i<6; i++) {
		cin >> dice[i];	
		m1 = min(m1, dice[i]);
		mm = max(mm, dice[i]);
	}

	if(n == 1) {
		cout << dice[0] + dice[1] + dice[2] + dice[3] + dice[4] + dice[5] - mm << endl;
		return 0;
	}

	for (int i = 0; i < 6; i++) {
		m1 = min(m1, dice[i]);
		for (int j = i + 1; j < 6; j++) {
			if (i + j == 5) {
				continue;
			}
			m2 = min(m2, dice[i] + dice[j]);
			for (int k = j + 1; k < 6; k++) {
				if (j + k == 5 || k + i == 5) {
					continue;
				}
				m3 = min(m3, dice[i] + dice[j] + dice[k]);
			}
		}
	}

	// for(int i=0; i<6; i++) {
	// 	for(int j=i+1; j<6; j++) {
	// 		if(i + j == 5) continue;
	// 		m2 = min(m2, dice[i] + dice[j]);
	// 	}
	// }

	// for(int i=0; i<6; i++) {
	// 	for(int j=i+1; j<6; j++) {
	// 		for(int k=j+1; k<6; k++) {
	// 			if(j + k == 5 || k + i == 5) continue;
	// 			m3 = min(m3, dice[i] + dice[j] + dice[k]);
	// 		}
	// 	}
	// }
	
	ans += (5 * (ll)n*n - 16 * n + 12) * m1;
	ans += (4 * m3);
	ans += (8 * n - 12) * m2;
	
	cout << ans << endl;
	
}

