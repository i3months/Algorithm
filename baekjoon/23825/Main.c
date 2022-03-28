#include <stdio.h>

int main(){
	int N;
	int M;
	scanf("%d %d", &N, &M);

	int N1 = N / 2;
	int M1 = M / 2;

	if(N1 > M1){
		printf("%d", M1);
	}else{
		printf("%d", N1);
	}
    
}