#include <stdio.h>

int main(){
    
    int sum = 0;
    int frequency = 0;
    int arr[10001];

    for(int i=0; i<10; i++){
        int temp;
        scanf("%d", &temp);    
        arr[temp]++;
        sum = sum + temp;
    }

    int mean = sum / 10;
    int min = 0;

    for(int i=0; i<1000; i++){
        if(arr[i] > min){
            min = arr[i];
            frequency = i;
        }
    }
    
    printf("%d\n%d", mean, frequency);

    
}