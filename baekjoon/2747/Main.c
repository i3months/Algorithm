#include <stdio.h>

int main(){

    int N, n1, n2, temp1, temp2;

    scanf("%d%d%d%d%d", &N, &n1, &n2, &temp1, &temp2); 

 for(int i=0; i<N; i++){
      if(i == 0 || i == 1){
        n1 = n2;
        n2 = 1;
      }else{
        temp1 = n1;
        temp2 = n2;
        n1 = temp2;
        n2 = temp1+temp2;
      }
    }
    printf("%d",n2);
    
    
}
