#include <bits/stdc++.h>
#define endl "\n"

using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int TC;
	cin >> TC;

	while(TC-- > 0) {
		int N, M;
		cin >> N >> M;

		vector<int> vec(N);

		for(int &k : vec) {
			cin >> k;
		}

		vector<int> vec2 = vec;

		sort(vec2.begin(), vec2.end());
		
		int ans = 0;
		
		for(int i=0; i<N && vec2[i] <= M; i++) {
			M -= vec2[i];
			ans++;
		}

		if(ans != 0 && ans != N && M >= vec[ans] - vec2[ans-1]) ans++;

		cout << N+1-ans << "\n";
		
	}
}