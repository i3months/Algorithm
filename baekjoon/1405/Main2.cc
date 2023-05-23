/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <bits/stdc++.h>

using namespace std;

int dr[] = {-1 ,1, 0, 0};
int dc[] = {0, 0, -1, 1};

int n;
double prob[4];
double res;
bool visited[10001][10001];

double dfs(int r, int c, int cnt) {
    if(cnt == n) return 1.0;
    
    visited[r][c] = 1;
    double res = 0.0;
    
    for(int i=0; i<4; i++) {
        int nextR = r + dr[i];
        int nextC = c + dc[i];
        
        if(visited[nextR][nextC]) continue;
        res = res + prob[i] * dfs(nextR, nextC, cnt+1);
    }
    
    visited[r][c] = false;
    return res;
}

int main() {
    
    cin >> n;
    
    for(int i=0; i<4; i++) {
        cin >> prob[i];
        prob[i] /= 100.0;
    }

    cout.precision(10);
    cout << fixed << dfs(14,14,0) << "\n";

    return 0;
}