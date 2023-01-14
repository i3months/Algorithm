#include <bits/stdc++.h>
#define endl "\n"
typedef long long ll;
using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(0);

	int n;
	cin >> n;

	int arr[100001];
	memset(arr, 0, sizeof(arr));

	for(int i=1; i<n; i++) {
		for(int j=i; j>1; j/=2) {
			arr[j] = arr[j/2];			
		}
		arr[1] = i+1;
	}

	arr[n] = 1;

	for(int i=1; i<n+1; i++) cout << arr[i] << " ";
}

