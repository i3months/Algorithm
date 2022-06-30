#include <stdio.h>

int main(void){
  int a, b;
  scanf("%d %d", &a,&b);

  if((a + b) % 2 != 0 || a < b){
    printf("-1");
  }else{
    printf("%d %d", (int)((a + b)/ 2), (int)((a+b)/ 2 -b));
  }

  

  return 0;
}
