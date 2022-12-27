#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

typedef struct {
	int num; bool check = false;
	vector<vector<int>> inDegree;
	vector<int> inDegreeSize;
	vector<int> adj;
} Node;

int N, M;
Node arr[200001];
vector<int> ans;

int main() {

	cin >> N >> M;
	vector<int> ingredient;

	for(int i=1; i<N+1; i++) arr[i].num = i;

	for(int i=0; i<M; i++) {
		ingredient.clear();

		int k;
		cin >> k;

		for(int j=0; j<k; j++) {
			int x;
			cin >> x;
			ingredient.push_back(x);
		}

		int r;
		cin >> r;

		for(int k : ingredient) {
			arr[k].adj.push_back(r);
		}

		arr[r].inDegree.push_back(ingredient);
		arr[r].inDegreeSize.push_back(ingredient.size());
	}

	int L;
	cin >> L; 
	
	for(int i=0; i<L; i++) {
		int y;
		cin >> y;
		arr[y].check = true;

		ans.push_back(y);
	}

	queue<Node> q;
	for(int k : ans) q.push(arr[k]);

	while(!q.empty()) {
		Node cur = q.front();
		q.pop();

		for(int i=0; i<cur.adj.size(); i++) {
			int nextP = cur.adj[i];
			if(arr[nextP].check) continue;

			for(int j=0; j<arr[nextP].inDegree.size(); j++) {
				if(arr[nextP].check) break;
				for(int k=0; k<arr[nextP].inDegree[j].size(); k++) {
					if(cur.num == arr[nextP].inDegree[j][k]) {
						arr[nextP].inDegree[j][k] = -1;
						arr[nextP].inDegreeSize[j]--;

						if(arr[nextP].inDegreeSize[j] == 0) {
							arr[nextP].check = true;
							break;
						}
					}
				}
			}

			if(arr[nextP].check) {
				ans.push_back(nextP);
				q.push(arr[nextP]);
			}
		}

		
	}

	cout << ans.size() << endl;
	sort(ans.begin(), ans.end());
	for(int k : ans) {
		cout << k << " ";
	}

	cout << endl;
	
	return 0;
}