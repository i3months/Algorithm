#include <cstdio>
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int N;
int arr[22][22];
int dp[21][1 << 21];

int dfs(int curNode, int curState){
    int &ret = dp[curNode][curState];
    if(ret != -1) return ret;

    ret = 0;

    for(int i=0; i<N; i++){
        if(arr[curNode][i] == 0) continue;
        if(curState & (1 << i)) continue; // 이거 이해 좀

        ret = max(ret, dfs(i, curState | 1 << i) + 1);        
    }
    return ret;
}

void trace(int curNode, int curState){
    for(int i=0; i<N; i++){        
        if(arr[curNode][i] == 0) continue;
        if(curState & (1 << i)) continue;
        if(dp[curNode][curState] == dp[i][curState | (1 << i)] + 1){
            cout << i+1;
            cout << " ";
            trace(i, curState | (1 << i));
            break;
        }
    }
}

int main(){
    cin >> N;    
    memset(dp, -1, sizeof(dp));

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> arr[i][j];            
        }
    }

    int L = dfs(0, 1);

    cout << L+1;
    cout << "\n";

    cout << 1;
    cout << " ";

    trace(0, 1);

    return 0;
}