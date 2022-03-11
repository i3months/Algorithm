#include <stdio.h>
int main()
{
	int A;
	int B;
	int N;

	scanf("%d %d %d", &A, &B, &N);

	int ans = A+B + (A*(N-1));

	for(int i =0; i<N; i++){
			printf("%d\n", ans);
			ans = ans + B;
	}
}