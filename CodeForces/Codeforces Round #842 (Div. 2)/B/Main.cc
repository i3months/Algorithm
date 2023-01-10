#include <bits/stdc++.h>
#define endl "\n"

using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int TC;
	cin >> TC;

	while(TC-- > 0) {
		int N, K;
		cin >> N >> K;

		vector<int> vec(N);

		for(int i=0; i<N; i++) cin >> vec[i];

		int x = 1;

		for(int i=0; i<N; i++) {
			if(vec[i] == x) x++;
		}

		cout << (N - x + K) / K << endl;

	}
}