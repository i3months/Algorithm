#include <stdio.h>

int main()
{

    long a, b;
    scanf("%ld %ld", &a, &b);

      if(a >= b){
        int temp;
        temp = b;
        b = a;
        a = temp;
    }
    long ans = 0;
    long temp1 = (b * (b+1)) / 2;
    long temp2 = (a * (a-1)) / 2;

  



    if(a == b){
        ans = b;
    }else if(a == 1){
        ans = temp1;
    }else if(a == 2){
        ans = temp1 - 1;
    }else{
        ans = temp1 - temp2;
    }
    
    

     printf("%ld", ans);

  

}