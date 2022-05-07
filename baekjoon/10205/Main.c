#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    
    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++){
      int M;
      scanf("%d", &M);

      char str[1101];

      scanf("%s", str);

      for(int j=0; j<strlen(str); j++){

        if(str[j] == 'b'){
          M = M - 1;
          //if(M == 0){
           // break;
          //}
        }

        if(str[j] == 'c'){
          M = M - 1;
          //if(M == 0){
           // break;
          //}
          M = M + 2;
        }
      }

      printf("Data Set %d:\n%d\n\n", i+1, M);
      
    }
    
}