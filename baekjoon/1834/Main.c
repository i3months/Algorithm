#include <stdio.h>

int main() {

  long long sum = 0;
  long long N;
  scanf("%lld", &N);

  for(int i=1; i<N; i++){
    sum = sum + (N*i + i); 
  }

  printf("%lld", sum);
}