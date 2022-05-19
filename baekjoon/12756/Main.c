#include <stdio.h>

int main() {

  int a, b, c, d;
  scanf("%d %d %d %d", &a, &b, &c, &d);

  while(1){
    b = b - c;
    d = d - a;

    if(b <= 0 && d <= 0){
      printf("DRAW");
      break;
    }else if(b <= 0){
      printf("PLAYER B");
      break;
    }else if(d <= 0){
      printf("PLAYER A");
      break;
    }
    

  }

}