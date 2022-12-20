#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {

	int N;
	cin >> N;

	vector<int> vec;
	for(int i=0; i<N; i++) {
		int a = 0;
		cin >> a;
		vec.push_back(a);
	}

	sort(vec.begin(), vec.end());


	vector<int> vec2;

	for(int i=0; i<N; i++) {
		for(int j=i; j<N; j++) {
			vec2.push_back(vec[i] + vec[j]);
		}
	}

	sort(vec2.begin(), vec2.end());

	int ans = -1;

	for(int i=0; i<N; i++) {
		for(int j=i+1; j<N; j++) {
			if(binary_search(vec2.begin(), vec2.end(), vec[j] - vec[i])) ans = max(ans, vec[j]);
		}
	}

	cout << ans << endl;

}