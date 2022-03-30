#include <stdio.h>

int main()
{

    

    int a1, a2, b1, b2, c1, c2, d1, d2;
    scanf("%d %d %d %d %d %d %d %d", &a1, &a2, &b1, &b2, &c1, &c2, &d1, &d2);

    int max = a2 - a1;

    int temp1 = a2 -a1;
    int temp2 = temp1 + b2 - b1;

    if(max > temp2){
        
    }else{
        max = temp2;
    }

    int temp3 = temp2 + c2 - c1;

    if(max > temp3){

    }else{
        max = temp3;
    }

    int temp4 = temp3 + d2 - d1;
    
    if(max > temp4){

    }else{
        max = temp4;
    }

    printf("%d", max);
    
  

}