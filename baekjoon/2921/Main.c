#include<stdio.h>

int main(){

    int N;
    scanf("%d", &N);    

    int sum = 0;

    for(int i=0; i<=N; i++){
        for(int j =i; j<=N; j++){
            sum = sum + i + j;
        }
    }

    printf("%d", sum);
}