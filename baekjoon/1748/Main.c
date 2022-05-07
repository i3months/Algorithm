#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main(){
  int N;
  long long ans = 0;
  scanf("%d", &N);

  for(int i =1; i<N+1; i = i * 10){
    ans = ans + N - i + 1;
  }

  printf("%lld", ans);
}