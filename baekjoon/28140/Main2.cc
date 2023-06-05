#include <bits/stdc++.h>
#define endl "\n"

typedef long long ll;
using namespace std;

const int N = 1e7+10;
const int INF = 987654321;
const ll INF2 = 10000000001;

int n, q, l, r;
string str;

vector<int> rv;
vector<int> bv;

int main(){

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> q >> str;

    rv.assign(str.size() + n, str.size());
    bv.assign(str.size() + n, str.size());

    for(int i=0; i<str.size(); i++) {
        if(str[i] == 'R') rv[i] = i;
        if(str[i] == 'B') bv[i] = i;
    }

    for(int i = str.size() - 1; i >= 0; i--){
        rv[i] = min(rv[i], rv[i + 1]);
        bv[i] = min(bv[i], bv[i + 1]);
    }

    while(q--){        
        cin >> l >> r;

        int a = rv[l];
        int b = rv[rv[a] + 1];
        int c = bv[rv[b] + 1];
        int d = bv[bv[c] + 1];

        if(d > r) cout << "-1" << endl;
        else cout << a << " " << b << " " << c << " " << d << endl;
        
    }

    return 0;
}