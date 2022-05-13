#include<stdio.h>
#include<string.h>
#include<math.h>
#include<stdlib.h>


int main(){

  int N;
  scanf("%d", &N);

  int arr[100000];

  for(int i=0; i<N; i++){
    scanf("%d", &arr[i]);
  }

  long long sum = 0;

  for(int i=0; i<N; i++){
    for(int j=0; j<N; j++){
      int temp = abs(arr[i] - arr[j]);
      //printf("%d\n", temp);
      sum = sum + temp;
    }
  }

  printf("%lld", sum);
    
}

    
