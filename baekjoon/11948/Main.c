#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    int a, b, c, d, e, f;
    scanf("%d %d %d %d %d %d", &a, &b, &c, &d, &e, &f);
    
    int arr[4];

    arr[0] = a;
    arr[1] = b;
    arr[2] = c;
    arr[3] = d;

    int arr2[2];

    arr2[0] = e;
    arr2[1] = f;

    for(int i=0; i<4; i++){
        for(int j=0; j<3; j++){
            if(arr[j] > arr[j+1]){
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp; 
            }
        }
    }

    int max = 0;
    if(arr2[0] > arr2[1]){
        max = arr2[0];
    }else{
        max = arr2[1];
    }

    int sum = arr[0] + arr[1] + arr[2] + arr[3] + max - arr[0];

    printf("%d", sum);

}