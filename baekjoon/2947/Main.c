#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    
    int arr[10];

    for(int i=0; i<5; i++){
      int tmp;
      scanf("%d", &tmp);

      arr[i] = tmp;
    }

    for(int i=0; i<5; i++){
      for(int j=0; j<4; j++){
        if(arr[j] > arr[j+1]){
          int tmp = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = tmp;

          printf("%d %d %d %d %d\n", arr[0], arr[1], arr[2], arr[3], arr[4]);
        }
      }
    }


    
    


}