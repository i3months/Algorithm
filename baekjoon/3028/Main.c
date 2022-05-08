#include <stdio.h>
#include <string.h>

int main() {

  char str[51];
  scanf("%s", str);

  int a1 = 1;
  int a2 = 0;
  int a3 = 0;

  for(int i=0; i<strlen(str); i++){    

    if(str[i] == 'A'){
      if(a1 == 1){
        a1 = 0;
        a2 = 1;
        
      }else

      if(a2 == 1){
        a2 = 0;
        a1 = 1;
        
      }
    }

    if(str[i] == 'B'){
      if(a2 == 1){
        a3 = 1;
        a2 = 0;
      }else
      if(a3 == 1){
        a2 = 1;
        a3 = 0;
      }
    }

    if(str[i] == 'C'){
      if(a3 == 1){
        a1 = 1;
        a3 = 0;
      }else
      if(a1 == 1){
        a1 = 0;
        a3 = 1;
      }
    }


    
  }

  if(a1 == 1){
      printf("1");
    }
  if(a2 == 1){
      printf("2");
    }
  if(a3 == 1){
      printf("3");
    }

}