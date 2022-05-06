#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    
    int N;
    scanf("%d", &N);

    for(int i=1; i<N+1; i++){
      int a;
     

      char oper;
     

      int b;
     

      char tmp;
     

      int res;
     

      scanf("%d %c %d %c %d", &a, &oper, &b, &tmp, &res);

      if(oper == '+'){
        if(a + b == res){
          printf("Case %d: YES\n", i);
        }else{
          printf("Case %d: NO\n", i);
        }
      }

      if(oper == '-'){
        if(a - b == res){
          printf("Case %d: YES\n", i);
        }else{
          printf("Case %d: NO\n", i);
        }
      }

      
    }
    
    
    
}
