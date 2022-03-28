#include <stdio.h>

int main(){
    int N, piece = 1, a = 1, i;

    scanf("%d", &N);

    for(i = 0; i < N; i++){
        if(i%2 != 0){
            a += 1;
        }
        piece += a;
    }
    printf("%d", piece);
    
}