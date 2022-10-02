#include <iostream>
#include <stdlib.h>
#include <cstring>

using namespace std;

int N;
int dp[1000001];

int main() {

    cin >> N;

    dp[1] = 1;
    dp[2] = 2;

    for(int i=3; i<N+1; i++){
        if(i % 2 == 1){
            dp[i] = dp[i-1];
        }

        if(i % 2 == 0){
            dp[i] = (dp[i-1] + dp[i/2]);
            dp[i] %= 1000000000;
        }
    }

    cout << dp[N];
    
    
    return 0;
}