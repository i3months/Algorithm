#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int n;
vector<pair<int, int>> flowers;


int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	cin >> n;
	
	for(int i=0; i<n; i++) {
		int s1, s2, e1, e2;

		cin >> s1 >> s2 >> e1 >> e2;

		int startDay = s1 * 100 + s2;
		int endDay = e1 * 100 + e2;

		if(startDay < 301) startDay = 301;
		if(endDay > 1130) endDay = 1201;

		flowers.push_back({startDay, endDay});
	}

	sort(flowers.begin(), flowers.end());

	int start = -1;
	int end = 301;
	int maxEndDay = -1;
	int maxDayIdx = -1;
	int ans = 0;

	for(int i=0; i<n; i++) {
		if(flowers[i].first > start && flowers[i].first <= end) {
			if(maxEndDay < flowers[i].second) {
				maxEndDay = flowers[i].second;
				maxDayIdx = i;				
			}

			if(flowers[i].second == 1201) {
				ans++;
				end = maxEndDay;
				break;
			}
				
		} else {
			if(end >= maxEndDay) break;

			ans++;
			start = end;
			end = maxEndDay;
			i--;
		}
	}

	if(end == 1201) cout << ans << endl;
	else cout << 0 << endl;
	
	
	
}