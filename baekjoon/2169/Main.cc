#include <iostream>
#include <algorithm>

using namespace std;

const int INF = 987654321;

int N, M;
int map[1000][1000];
int dp[1000][1000][3];
bool visit[1000][1000];

int dr[] = {0,0,1};
int dc[] = {1,-1,0};

int solve(int r, int c, int dir) {
    if(r == N-1 && c == M-1) return map[r][c];
    if(dp[r][c][dir] != -INF) return dp[r][c][dir];

    visit[r][c] = true;

    int cmp = -INF;

    for(int i=0; i<3; i++) {
        int nextR = r + dr[i];
        int nextC = c + dc[i];

        if(nextR >= N || nextR <= -1 || nextC >= M || nextC <= -1) continue;
        if(visit[nextR][nextC] == true) continue;

        cmp = max(cmp, solve(nextR, nextC, i));
        // cmp = Bigger(cmp, solve(nextR, nextC, i));
    }
    visit[r][c] = false;
    dp[r][c][dir] = map[r][c] + cmp;
    return dp[r][c][dir];
}

int main() {
    cin >> N >> M;

    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            cin >> map[i][j];
        }
    }

    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            for(int k=0; k<3; k++) {
                dp[i][j][k] = -INF;
            }
        }
    }

    cout << solve(0,0,0) << endl;

    
}