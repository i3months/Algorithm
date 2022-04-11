#include<stdio.h>
#include <string.h> 

int main()
{
   int N;
   scanf("%d", &N);

   for(int i=0; i<N; i++){
       int M;
       scanf("%d", &M);
       int arr[21];
       for(int j=0; j<M; j++){
           int temp;
           scanf("%d", &temp);
           arr[j] = temp;
       }   

       int max = 0;
       int min = 100;
       
       for(int j=0; j<M; j++){
           if(arr[j] > max){
               max = arr[j];
           }
           if(arr[j] < min){
               min = arr[j];
           }

       }

       int ans = (max - min) * 2;

       printf("%d\n", ans);
   }

    
}
