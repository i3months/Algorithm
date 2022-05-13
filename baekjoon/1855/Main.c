#include<stdio.h>
#include<string.h>
#include<math.h>
#include<stdlib.h>

int main(){

  int M;
  scanf("%d", &M);

  char str[212];
  scanf("%s", str);

  int N = strlen(str) / M;
  //printf("%d %d", N ,M);
  
  char arr[1000][1000];

  int idx = 0;

  

  for(int i=0; i<N; i++){
    for(int j=0; j<M; j++){      
      arr[i][j] = str[idx];
      idx++;
    }
  }

  for(int i=0; i<M; i++){
    for(int j =0; j<N; j++){
      if(j % 2 == 0){
        printf("%c", arr[j][i]);
      }else{
        printf("%c", arr[j][M-i-1]);        
      }
    }    
  }

  
    
}

    
