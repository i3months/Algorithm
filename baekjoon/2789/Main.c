#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
  int N;
  scanf("%d ", &N);

  for(int i=1; i<N+1; i++){
    
    char str[501];
    gets(str);

    printf("%d. %s\n", i, str);
    
  }

}
