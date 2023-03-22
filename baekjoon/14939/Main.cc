#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;

typedef long long ll;
using namespace std;

bool curMap[11][11];
bool savedMap[11][11];

int dr[] = {-1,1,0,0};
int dc[] = {0,0,-1,1};

int ans = INF;

void light(int r, int c) {
	curMap[r][c] = !curMap[r][c];

	for(int i=0; i<4; i++) {
		int nextR = r + dr[i];
		int nextC = c + dc[i];

		if(nextR >= 10 || nextR <= -1 || nextC >= 10 || nextC <= -1) continue;

		curMap[nextR][nextC] = !curMap[nextR][nextC];
	}
}

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	for(int i=0; i<10; i++) {
		for(int j=0; j<10; j++) {
			char tmp; 
			cin >> tmp;
			if(tmp == 'O') savedMap[i][j] = 1;
			else savedMap[i][j] = 0;
		}
	}

	for(int i=0; i<(1 << 10); i++) {
		int cnt = 0;

		for(int a=0; a<10; a++) {
			for(int b=0; b<10; b++) {
				curMap[a][b] = savedMap[a][b];
			}
		}

		for(int j=0; j<10; j++) {
			if(i & (1 << j)) {
				cnt++;
				light(0, j);
			}
		}

		for(int aa=0; aa<10; aa++) {
			for(int bb=0; bb<10; bb++) {
				if(curMap[aa-1][bb]) {
					light(aa, bb); cnt++;
				}
			}
		}

		bool isAnswer = false;

		for(int aaa=0; aaa<10; aaa++) {
			for(int bbb=0; bbb<10; bbb++) {
				if(curMap[aaa][bbb]) {
					isAnswer = true;
				}
			}
		}

		if(!isAnswer) ans = min(cnt, ans);							
		
	}

	if(ans == 987654321) cout << -1 << endl; 
	else cout << ans << endl;
	
}