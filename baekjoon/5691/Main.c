#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{  

  while(1){
    int a, b;
    scanf("%d %d", &a, &b);

    if(a == 0 && b == 0){
      break;
    }

    int arr[3];
    
    int temp = (2 * a) - b;
    if(temp > -a + 2*b){
      temp = -a + 2 * b;
    }

    if(temp > (a+b) / 2){
      temp = (a+b) / 2;
    }

    printf("%d\n", temp);
    
  }

  
  
   
  
}