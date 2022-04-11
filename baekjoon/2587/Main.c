#include<stdio.h>
#include <string.h> 

int main()
{
  int arr[5];
  int sum = 0;

  for(int i=0; i<5; i++){
      int temp;
      scanf("%d", &temp);
      sum = sum + temp;
      arr[i] = temp;
  }

  for(int i=0; i<5; i++){
      for(int j=0; j<5-1; j++){
          if(arr[j] > arr[j+1]){
              int temp = arr[j+1];              
              arr[j+1] = arr[j];
              arr[j] = temp;
          }
      }
  }

  int ans = sum / 5;
  int ans2 = arr[5/2];
  printf("%d\n%d", ans, ans2);

    
}
