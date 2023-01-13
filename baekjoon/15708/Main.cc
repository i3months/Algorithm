#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int N, P, T;

	cin >> N >> T >> P;
	priority_queue<int> pq;

	int sum = 0;
	int cnt = 0;	
	int maxVal = -1;

	for(int i=0; i<N; i++) {
		int val;
		cin >> val;

		if(T - i * P < 0) break;
		
		sum += val;
		pq.push(val);
		cnt++;

		while(sum + i * P > T) {
			cnt--;
			sum -= pq.top();
			pq.pop();
		}
		maxVal = max(maxVal, cnt);
	}		

	cout << maxVal << endl;
}

