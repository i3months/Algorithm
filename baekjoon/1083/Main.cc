#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int n, s;
	int arr[51];

	cin >> n;

	for(int i=0; i<n; i++) cin >> arr[i];

	cin >> s;

	for(int i=0; i<n; i++) {
		int maxVal = arr[i];
		int maxIdx = i;

		for(int j=i+1; j<n; j++) {
			int moveLeft = s - (j-i);
			if(moveLeft >= 0) {
				if(maxVal < arr[j]) {
					maxVal = arr[j];
					maxIdx = j;
				}
			}
		}
		
		for(int j=maxIdx; j>i; j--) {
			swap(arr[j-1], arr[j]);
			s--;
		}		
	}

	for(int i=0; i<n; i++) cout << arr[i] << " ";
	
	
}