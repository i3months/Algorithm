#include <stdio.h>

int main()
{
    int a,b,c;
    int countA = 0;
    int countB = 0;

    scanf("%d%d%d",&a,&b,&c);

    if(a == 1){
        countA++;
    }else{
        countB++;
    }
    if(b == 1){
        countA++;
    }else{
        countB++;
    }
    if(c == 1){
        countA++;
    }else{
        countB++;
    }

    if(countA>countB){
        printf("1");
    }else{
        printf("2");
    }

        
}