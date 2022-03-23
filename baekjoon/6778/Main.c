#include <stdio.h>

int main()
{

	int N;
	int M;
	scanf("%d %d", &N, &M);

	if(N >= 3 && M <= 4){
		printf("TroyMartian\n");
		if(N <= 6 && M >= 2){
			printf("VladSaturnian\n");
		}
		if(N <= 2 && M <= 3){
			printf("GraemeMercurian\n");
		}
	}else if(N <= 6 && M >= 2){
		if(N <= 2 && M <= 3){
			printf("GraemeMercurian\n");
		}
		printf("VladSaturnian\n");
	}else if(N <= 2 && M <= 3){
		printf("GraemeMercurian\n");
	}else{

	}
  
}