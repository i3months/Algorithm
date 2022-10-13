#include <iostream>
#include <cstring>

using namespace std;

int N, M;
int INF = 987654321;
int memory[101];
int overhead[101];
int dp[101][100001];
int res = INF;

int main(){
    cin >> N >> M;

    memset(memory, 0, sizeof(memory));
    memset(overhead, 0, sizeof(overhead));
    memset(dp, 0, sizeof(dp));
    
    for(int i=1; i<N+1; i++) cin >> memory[i];
    for(int i=1; i<N+1; i++) cin >> overhead[i];

    for(int i=1; i<N+1; i++){
        for(int j=0; j<10001; j++){
            if(overhead[i] <= j) dp[i][j] = max(dp[i-1][j], dp[i-1][j-overhead[i]] + memory[i]);
            else dp[i][j] = dp[i-1][j];

            if(dp[i][j] >= M)res = min(res, j);

        }
    }

    cout << res;


}