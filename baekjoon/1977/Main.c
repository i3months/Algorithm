#include <stdio.h>

int main()
{
    int M;
    int N;
    scanf("%d", &M);
    scanf("%d", &N);
    
    int min = 0;
    int sum = 0;
    
    int i = 0;

    int chk = 1;

    while(1){
        int temp = i * i;

        if(temp >= M && temp<= N){
            sum = sum + temp;
            if(chk){
                min = sum;
            }
            chk = 0;
        }   

        if(temp > N){
            break;
        }
     
        ++i;
    }

    if(min == 0){
        printf("%d", -1);
    }else{
        printf("%d\n%d", sum, min);
        
    }
  
}
