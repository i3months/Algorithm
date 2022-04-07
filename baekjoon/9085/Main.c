#include <stdio.h>

int main(){
    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++){
        int M;
        scanf("%d", &M);
        int sum = 0;
        for(int j=0; j<M; j++){
            int temp;
            scanf("%d", &temp);

            sum = sum + temp;
        }
        printf("%d\n", sum);
    }
}