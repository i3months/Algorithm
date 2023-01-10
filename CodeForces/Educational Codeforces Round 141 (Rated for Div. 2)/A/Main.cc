#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <memory.h>
#include <cmath>

using namespace std;
typedef long long ll;

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int TC;

	cin >> TC;

	while(TC-- > 0) {
		int N;
		cin >> N;

		int arr[51];
		int sum[51];

		memset(arr, 0, sizeof(arr));
		memset(sum, 0, sizeof(sum));

		for(int i=1; i<N+1; i++) {
			cin >> arr[i];	
		}//

		sort(arr, arr+N+1, greater<int>());		
		
		bool check = false;

		int save = arr[0];
		int save2 = 0;		
		for(int i=0; i<N; i++) {

			bool check2 = false;
			save2 = arr[i];
			
			arr[0] = arr[i];
			arr[i] = save;			

			sum[0] = arr[0];

			for(int j=1; j<N; j++) {
				sum[j] = sum[j-1] + arr[j];
			}

			for(int j=1; j<N; j++) {
				if(arr[j] == sum[j-1]) {
					check2 = true;
					break;
				}
			}

			if(check2) {
				arr[0] = save;
				arr[i] = save2;
				continue;				
			} else {
				check = true;
				break;
			}	

		}

		if(check) {
			cout << "YES" << "\n";
			for(int i=0; i<N; i++) {
				cout << arr[i] << " ";
			}
			cout << "\n";
		} else {
			cout << "NO" << "\n";
		}

		
	}
	
	
}