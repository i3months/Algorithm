#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    
    int N;
    scanf("%d", &N);

    int arr[511];

    for(int i=0; i<N; i++){
      int a;
      scanf("%d", &a);

      arr[i] = a;      
    }

    if(arr[2] - arr[1] == arr[1] - arr[0]){
      int cmd = arr[1] - arr[0];
      printf("%d", arr[N-1] + cmd);
    }else{
      int cmd = arr[1] / arr[0];
      printf("%d", arr[N-1] * cmd);
    }
}