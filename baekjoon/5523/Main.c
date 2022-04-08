#include <stdio.h>

int main(){

    int N;
    scanf("%d", &N);
    int a = 0;
    int b= 0;
    for(int i=0; i<N; i++){
        int temp1; 
        int temp2;
        scanf("%d", &temp1);
        scanf("%d", &temp2);
        if(temp1 > temp2){
            a++;
        }else if(temp1<temp2){
            b++;
        }
        
    }

    printf("%d %d", a, b);
}