#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

typedef long long ll;


ll N, M;
vector<pair<ll, ll>> vec;    
vector<ll> v;

ll sum[300001];
ll v1[300001];
ll v2[300001];

int main() {        

    cin >> N >> M;    

    for(int i=0; i<N; i++) {
        ll a;
        ll b;

        cin >> a >> b;        

        vec.push_back(pair(b, a)); 
        v.push_back(b);

    }

    sort(vec.begin(), vec.end());
    sort(v.begin(), v.end());    

    for(int i=1; i<N+1; i++) {
        sum[i] = sum[i-1] + vec[i-1].second;        
        v2[i] = v2[i-1] + (vec[i-1].first * vec[i-1].second);
    }

    for(int i=0; i<M; i++) {
        ll query;        
        cin >> query;

        ll idx = lower_bound(v.begin(), v.end(), query) - v.begin();
        cout << v2[N] - 2*v2[idx] - (query*(sum[N]-2*sum[idx])) << "\n";
    }
    
    
    
}