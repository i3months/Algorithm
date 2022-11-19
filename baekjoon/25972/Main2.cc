#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, ans;
pair<int, int> arr[5000000];

int main() {

	cin >> N; 

	for(int i=0; i<N; i++) {
		cin >> arr[i].first >> arr[i].second;		
	}

	sort(arr, arr + N);

	int prev = -1;
	for(int i=0; i<N; i++) {
		if(prev < arr[i].first) ans++;
		prev = arr[i].first + arr[i].second;
	}

	cout << ans << endl;
}