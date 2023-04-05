#include <bits/stdc++.h>
using namespace std;
 

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;

    cin >> n;
    
    vector<int> v;
    v.resize(n);



    long long res = 0;

    for(int i=0; i<n; i++) {
        cin >> v[i];
    }

    sort(v.begin(), v.end());

    for(int i=0; i<n-2; i++) {
        for(int j=i+1; j<n-1; j++) {

            int sum = v[i] + v[j];
            int target = -sum;

            int upper = upper_bound(v.begin() + j + 1, v.end(), target) - v.begin();
            int lower = lower_bound(v.begin() + j + 1, v.end(), target) - v.begin();
            
            res += (upper - lower);
            
        }
    }

    cout << res << "\n";
}