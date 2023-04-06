	#include <bits/stdc++.h>
	#define endl "\n"
	#define INF 987654321;
	#define INF2 1000000001;

	typedef long long ll;
	using namespace std;

	vector<int> v;
	vector<int> seq;

	int n, m;

	int main() {
		ios::sync_with_stdio(false);
		cin.tie(0);

		cin >> n >> m;

		v.resize(n);

		for(int i=0; i<n; i++) cin >> v[i];

		int left = 1;
		int right = 300000;
		int ans = -1;

		while(left <= right) {
			int mid = (left + right) / 2;

			bool flag = false;

			int cnt = 1;
			int sum = 0;

			for(int i=0; i<n; i++) {
				if(v[i] > mid) {
					flag = true;	
					break;			
				}

				if(sum + v[i] <= mid) {
					sum += v[i];
					continue;
				}

				if(v[i] <= mid) {
					sum = v[i];
				}

				cnt++;
			}

			if(!flag && cnt <= m) {
				ans = mid;
				right = mid-1;
			} else {
				left = mid + 1;
			}

		}

		cout << ans << endl;

		int cnt = 0;
		int sum = 0;
		int sigsum = 0;

		for(int i=0; i<n; i++) {
			if(sum + v[i] <= ans) {				
				sum += v[i];
				cnt++;			
				if(sum == ans) sigsum = cnt;
				continue;
			}

			seq.push_back(cnt);
			sum = v[i];
			cnt = 1;
		}
		seq.push_back(cnt);

		if(seq.size() < m) {
			while(1) {
				bool flag = false;
				// cout << seq.size() << " : " << m << endl;
				if(seq.size() >= m) break;			

				for(int i=0; i<seq.size(); i++) {
					if(sigsum == seq[i]) continue;
					if(seq[i] > 1) {					
						seq.insert(seq.begin() + i + 1, seq[i] - 1);
						seq[i] = seq[i] - 1;
					}			
					if(seq.size() >= m) {
						flag = true;
						break;		
					}
				}

				if(flag) break;
			}	
		}

		for(int i=0; i<seq.size(); i++) {
			cout << seq[i] << " ";
		}


	}