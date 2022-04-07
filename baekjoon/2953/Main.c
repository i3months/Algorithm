#include <stdio.h>

int main(){
    
    int arr[5];

    for(int i=0; i<5; i++){
        int a1;
        int a2;
        int a3;
        int a4;
        scanf("%d", &a1);
        scanf("%d", &a2);
        scanf("%d", &a3);
        scanf("%d", &a4);
        arr[i] = a1+a2+a3+a4;

    }
    
    int t = 0;

    int max = 0;

    for(int i=0; i<5; i++){
        if(max < arr[i]){
            max = arr[i];
            t = i+1;
        }
    }

    printf("%d %d", t, max);
}