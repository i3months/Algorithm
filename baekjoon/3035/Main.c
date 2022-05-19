#include <stdio.h>

int main() {

	int R, C, ZR, ZC;
	scanf("%d %d %d %d", &R, &C, &ZR, &ZC);

	char arr[51][51];

	for(int i=0; i<R; i++){
		scanf("%s", arr[i]);
	}

	for(int i=0; i<R; i++){
		for(int j=0; j<ZR; j++){
			for(int k=0; k<C; k++){
				for(int p=0; p<ZC; p++){
					printf("%c", arr[i][k]);
				}				
			}
			printf("\n");
		}
	}
	


}