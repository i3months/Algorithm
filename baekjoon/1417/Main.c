#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {

	int N;
	scanf("%d", &N);

	int count = 0;
	int * vote = (int*)malloc(sizeof(int) * N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &vote[i]);
	}

	while (1) {
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (vote[i] >= vote[idx]) {
				idx = i;
			}
		}
        
		if (idx == 0)
			break;

		vote[0]++;
		vote[idx]--;
		count++;
	}

	printf("%d", count);
	
}