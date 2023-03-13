#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

const int MAX = 1000;
int INF = 987654321;
string res;
int arr[MAX][MAX];

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int r, c;	
	cin >> r >> c;	
	
	if(r % 2) {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c-1; j++) {
				if(i % 2 == 0) res += "R";
				else res += "L";                    
			}
			if(i != r-1) res += "D"; 
		}
		cout << res << endl;
		return 0;
	}

	else if(!(r % 2) && c % 2) {
		for(int i=0; i<c; i++) {
			for(int j=0; j<r-1; j++) {
				if(i % 2 == 0) res += "D";
				else res += "U";                    
			}
			if(i != c-1) res += "R";
		}
		cout << res << endl;
		return 0;
	}

	int minValue = 987654321;

	pair<int, int> locate;        

	for(int i=0; i<r; i++) {            
		for(int j=0; j<c; j++) {                
			cin >> arr[i][j];                
			if((i + j) % 2) {
				if(minValue > arr[i][j]) {
					minValue = max(minValue, arr[i][j]);                        
					locate = pair(i,j);
				}
			}
		}
	}

	// for(int i=0; i<r; i++) {
	//     for(int j=0; j<c; j++) {
	//         if((i + r) % 2 ==0) {
	//             if(minValue > arr[i][j]) {
	//                 minValue = Math.max(minValue, arr[i][j]);
	//                 locate = new Locate(i,j);
	//             }
	//         }
	//     }
	// }

	int rr = locate.first % 2 ? locate.first - 1 : locate.first;
	
	for(int i=0; i<rr; i++) {
		for(int j=0; j<c-1; j++) {
			if(i % 2 == 0) res += "R";
			else res += "L";
		}
		res += "D";
	}

	rr = locate.second;

	for(int i=0; i<rr; i++) {
		if(i % 2 == 0) res += "DR";
		else res += "UR";
	}

	for(int i=rr; i<c-1; i++) {
		if(i % 2 == 0) res += "RD";
		else res += "RU";
	}

	if(locate.first % 2 == 0) rr = r - (locate.first + 2);
	else rr = r - (locate.first + 1);

	for(int i=0; i<rr; i++) {
		res += "D";
		for(int j=0; j<c-1; j++) {
			if(i % 2 == 0) res += "L";
			else res += "R";
		}
	}

	cout << res << endl;
	
}