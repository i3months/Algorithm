#include <stdio.h>

long long fibo(int n)
{
	if(n == 0){
		return 0;
	}
	if(n == 1){
		return 1;
	}
	return fibo(n-1) + fibo(n-2);
}

int main()
{

	long long N;
	long long arr[1000000];

	arr[0] = 0;
	arr[1] = 1;

	scanf("lld", &N);

	for(int i = 0; i<=N; i++)
	{
		arr[i+2] = arr[i] + arr[i+1];
	}

	printf("%lld", arr[N]);


  
}