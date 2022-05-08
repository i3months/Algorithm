#include <stdio.h>
#include <string.h>

int main() {

  while(1){
    int N;
    scanf("%d", &N);

    if(N == 0){
      break;
    }

    int ans = 0;

    for(int i=1; i<N+1; i++){
      ans = ans + (i*i);
    }

    printf("%d\n", ans);

  }


}