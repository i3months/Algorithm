#include<stdio.h>

int main(){

    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++){
        int temp1;
        int temp2;
        scanf("%d", &temp1);
        scanf("%d", &temp2);

        int ans = temp2 - temp1 + 2;
        printf("%d\n", ans);
    }

}