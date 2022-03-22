#include <stdio.h>
#include <math.h>
int arr[1000001];
int main()
{
	long long N, i, B, C,rst=0;
	int NC;

	scanf("%lld", &N);

	for (i = 1; i <= N; i++){
    scanf("%d", &arr[i]);
    }

	scanf("%lld%lld", &B, &C);

	for (i = 1; i <= N; i++) {
		NC = 0;
		if (arr[i] - B > 0)
			NC = ceil((double)(arr[i] - B) / C);
		if ((arr[i] - B) % C != 0)
			NC + 1;
		rst += 1 + NC;
	}

	printf("%lld\n", rst);
  
}