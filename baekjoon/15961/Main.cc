#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

const int N = 1e7+10;

int n, d, k, c;
vector<int> sushi;
int sushis[3001] = {0, };
deque<int> dq;
int res = 0;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> d >> k >> c;

	sushi.resize(n);

	for(int i=0; i<n; i++) cin >> sushi[i];

	int cnt = 0;

	for(int i=0; i<k; i++) {
		dq.push_back(sushi[i]);

		if(!sushis[sushi[i]]) cnt++;			
		sushis[sushi[i]]++;

		res = max(res, cnt);				
	}

	for(int i=0; i<n-1; i++) {
		dq.pop_front();

		sushis[sushi[i]]--;
		if(!sushis[sushi[i]]) cnt--;

		dq.push_back(sushi[(i + k) % n]);

		if(!sushis[sushi[(i + k) % n]]) cnt++;
		sushis[sushi[(i + k) % n]]++;

		if(!sushis[c]) res = max(res, cnt+1);
		else res = max(res, cnt);
		


	}

	cout << res << endl;
	
	
	
}