#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {	

	char arr1[200000];
	char target[200000];

	gets(arr1);
	gets(target);

	int cnt = 0;

	for(int i=0; i<strlen(arr1); i++){
		if(arr1[i] == target[0]){
			if(strlen(target) == 1){
				cnt++;				
			}else{
			for(int j=1; j<strlen(target); j++){
				
				if(arr1[i+j] != target[j] || i + j > strlen(arr1)){
					break;
				}else if(j == strlen(target) - 1){
					cnt++;
				}

			}			}
			
		}
	}

	printf("%d", cnt);

	
}