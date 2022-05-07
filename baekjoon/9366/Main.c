#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main(){

    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++){
      int arr[3];
      scanf("%d %d %d", &arr[0], &arr[1], &arr[2]);

      for(int i=0; i<3; i++){
        for(int j=0; j<2; j++){
          if(arr[j] > arr[j+1]){
            int temp = arr[j+1];
            arr[j+1] = arr[j];
            arr[j] = temp;
          }
        }
      }

     


      if(arr[0] + arr[1] <= arr[2]){
        printf("Case #%d: invalid!\n", i+1);        
      }else if(arr[0] == arr[1]  && arr[1] == arr[2]){
        printf("Case #%d: equilateral\n", i+1);
      }else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]){
        printf("Case #%d: isosceles\n", i+1);
      }else{
        printf("Case #%d: scalene\n", i+1);
      }
    }

    
}