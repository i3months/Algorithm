#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    int arr[31] = {0,};
    
    for(int i=0; i<28; i++){
      int temp;
      scanf("%d", &temp);
      arr[temp] = 1;
    }

    for(int i=1; i<31; i++){
      if(arr[i] != 1){
        printf("%d\n", i);
      }
    }
}
