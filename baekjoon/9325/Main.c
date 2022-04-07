#include<stdio.h>

int main(){

    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++){

        int price = 0;
        scanf("%d", &price);

        int M = 0;
        int option = 0;

        scanf("%d", &M);

        for(int j=0; j<M; j++){
            int temp1 = 0;
            int temp2 = 0;
            scanf("%d", &temp1);
            scanf("%d", &temp2);        

            option = option + (temp1 * temp2);
        }

        int ans = price + option;
        printf("%d\n", ans);


    }


}