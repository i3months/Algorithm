
#include <iostream>
#include <vector>
#include <algorithm>
 
using namespace std;
 
int main() {
 
    int n;
    cin>>n;

    int remind = 1000 - n;
 
    vector<int> vec = {500, 100, 50, 10, 5, 1};
 
    int cnt=0;
 
    for(int i=0; i<vec.size(); i++){        
        while(remind - vec[i]>=0){
            cnt++;
            remind-=vec[i];
        }
    }
 
    cout<<cnt<<endl;
    return 0;
}
