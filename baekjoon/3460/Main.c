#include<stdio.h>

int main()
{
	int t, n;

	scanf("%d", &t);

	for (int i = 0; i < t; i++) {
		scanf("%d", &n);

		int cnt = 0;

		while (n != 0)
		{
			if (n % 2 == 1) {
				printf("%d ", cnt);
			}
			n = n / 2;
			cnt++;
		}
		printf("\n");
	}

	return 0;
}
