#include <bits/stdc++.h>
#define endl "\n"
#define INF 987654321;
#define INF2 1000000001;

typedef long long ll;
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);

	int TC;

	cin >> TC;

	for(int z=1; z<TC+1; z++) {

		int n, k;
		int arr[1000001];
		int lis[1000001];
		int len = 1;
		cin >> n >> k;

		for (int i = 0; i < n; i++)
			cin >> arr[i];

		lis[0] = arr[0];

		for (int i = 1; i < n; i++)
		{
			int cur = arr[i];

			if (lis[len - 1] < cur)
			{
				len++;
				lis[len - 1] = cur;
			}
			else
			{
				int start = 0;
				int fin = len;

				while (start < fin)
				{
					int mid = (start + fin) / 2;

					if (lis[mid] < cur)
						start = mid + 1;
					else
						fin = mid;
				}

				lis[start] = cur;
			}
		}
		
		if(len >= k) {
			cout << "Case #" << z << endl << 1 << endl; 
		} else {
			cout << "Case #" << z << endl << 0 << endl; 
		}

		// cout << len << endl;
	}
}