#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int ans = 0;
int mult = 0;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int n;
	int arr[51];	

	cin >> n;


	for(int i=0; i<n; i++) {
		int multTemp = 0;
		cin >> arr[i];
		if(arr[i] == 0) continue;
		if(arr[i] != 0) ans++;

		while(true) {
			if(arr[i] == 1) break;
			if(arr[i] % 2 == 0) {
				arr[i] /= 2;
				multTemp++;
			} else if(arr[i] % 2 != 0) {
				arr[i]--;
				ans++;
			}			
		}

		mult = max(mult, multTemp);
	}

	cout << mult + ans << endl;
	
	
	
}