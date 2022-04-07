#include<stdio.h>

int main(){

    int price;
    scanf("%d", &price);

    for(int i=0; i<9; i++){
        int temp;
        scanf("%d", &temp);
        
        price = price - temp;
    }

    printf("%d", price);
}