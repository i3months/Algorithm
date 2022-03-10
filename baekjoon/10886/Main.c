#include <stdio.h>

int main(void)
{

 int cute = 0;
 int non_cute = 0;
 int N;
 int temp;
 scanf("%d", &N );

 for(int i=0; i<N; i++){
     scanf("%d", &temp);
     if(temp == 0){
         non_cute++;
     }else{
         cute++;
     }
 }

 if(cute>non_cute){
     printf("Junhee is cute!");
 }else{
     printf("Junhee is not cute!");
 }



        
}