#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    
    while(1){
      int N;
      scanf("%d", &N);

      if(N == 0){
        break;
      }

      int prev = 0;




      for(int i=0; i<N; i++){
        int tmp;
        scanf("%d", &tmp);

        if(prev != tmp){
          printf("%d ", tmp);
        }
        
        prev = tmp;
        
      }
      printf("$ \n");

      


    }

}