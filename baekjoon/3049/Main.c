#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

long factorial(long n){
  if(n == 0){
    return 1;
  }
  if(n == 1){
    return 1;
  }else{
    return n * factorial(n-1);
  }

}

int main() {

  long N;
  scanf("%ld", &N);

  long ans = ((N) * (N-1) * (N-2) * (N-3)) / 24;

  printf("%ld", ans);
  
}
