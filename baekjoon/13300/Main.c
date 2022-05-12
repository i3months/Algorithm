#include<stdio.h>
#include<string.h>
#include<math.h>


int main(){

  int N, K;
  scanf("%d %d", &N, &K);

  int arr1[6];
  int arr2[6];

  for(int i=0; i<6; i++){
    arr1[i] = 0;
  }

  for(int i=0; i<6; i++){
    arr2[i] = 0;
  }

  for(int i=0; i<N; i++){
    int S, Y;
    scanf("%d %d", &S, &Y);
    
    if(S == 0){
      arr1[Y-1]++;
    }

    if(S == 1){
      arr2[Y-1]++;
    }
    
  }


  int cnt = 0;

  for(int i = 0; i<6; i++){

    if(arr1[i] != 0){

      if(arr1[i] / K == 0){
        cnt = cnt + 1;
      }else{
        if(arr1[i] % K == 0){
          cnt = cnt + (arr1[i] / K);
        }else{
          cnt = cnt + (arr1[i] / K) + 1;
        }
      }

    }


    if(arr2[i] != 0){
      if(arr2[i] / K == 0){
        cnt = cnt + 1;
      }else{
        if(arr2[i] % K == 0){
          cnt = cnt + (arr2[i] / K);
        }else{
          cnt = cnt + (arr2[i] / K) + 1;
        }
      }
    }
        
  }

  printf("%d", cnt);
    
}

    
