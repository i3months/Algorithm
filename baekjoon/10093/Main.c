#include <stdio.h>

int main(){

  long long N, M;

  scanf("%lld %lld", &N, &M);
  long long temp;

  if(N > M){
    temp = N;
    N = M;
    M = temp;

  }
  unsigned long long a = 0;
  long long b = M - N - 1;

  if(N == M){
    printf("%d\n", a);
  }else{
    printf("%lld\n", b);
  }

  for(long long i = N+1; i<M; i++){


    printf("%lld", i);
    printf(" ");
  }
  
    
}
