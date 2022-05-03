#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    
    while(1){
      int a;
      int b;
      int c;
      scanf("%d %d %d", &a, &b, &c);

      if(a ==0 && b == 0 && c == 0){
        break;
      }

      if(a + b <= c || a + c <= b || b + c <= a){
        printf("Invalid\n");
      }else

      if(a == b && b ==  c){
        printf("Equilateral\n");
      }else if((a == b) || (a == c) || (b == c)){
        printf("Isosceles\n");
      }else{
        printf("Scalene\n");
      }
    }

}