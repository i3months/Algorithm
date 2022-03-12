#include <stdio.h>

int main(){
    int N;
    scanf("%d", &N);

    int temp = N;
    int sum = 0;
    temp = (N * (N+1)) / 2;
    for(int i =0; i<N-1; i++){
        int asdf;
        scanf("%d", &asdf);
        sum = sum + asdf;
    }

    temp = temp - sum;
    printf("%d", temp);
    
    
}
