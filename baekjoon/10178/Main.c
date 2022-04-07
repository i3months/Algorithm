#include<stdio.h>

int main(){

    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++){
        int temp1 = 0;
        int temp2 =0;
        scanf("%d", &temp1);
        scanf("%d", &temp2);

        int temp3 = temp1 / temp2;
        int temp4 = temp1 % temp2;
        printf("You get %d piece(s) and your dad gets %d piece(s).\n", temp3, temp4);
    }

}