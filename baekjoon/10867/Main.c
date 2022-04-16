#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
  int N, temp;
  int chk[10000] = {0,};
  scanf("%d", &N);

  for(int i=0; i<N; i++){
    scanf("%d", &temp);
    chk[temp + 1000]++;
  }

  for(int i=0; i<10000; i++){
    if(chk[i] != 0){
      printf("%d ", i -1000);
    }
  }
}
