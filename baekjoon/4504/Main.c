#include <stdio.h>

int main()
{

    int n;
    scanf("%d", &n);

    while(1){
        int temp;
        scanf("%d", &temp);
        if(temp == 0){
            break;
        }
        
        if(temp % n == 0){
            printf("%d is a multiple of %d.\n", temp, n);
        }else{
            printf("%d is NOT a multiple of %d.\n", temp, n);
        }
    }
  
}