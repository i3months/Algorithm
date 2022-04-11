#include <stdio.h>

int main(){
    int arr[101];
    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++){
        int temp;
        scanf("%d", &temp);
        arr[i] = temp;
    }

    int v;
    scanf("%d", &v);

    int count = 0;

    for(int i=0; i<N; i++){
        if(arr[i] == v){
            count++;
        }
    }

    printf("%d", count);
    


}