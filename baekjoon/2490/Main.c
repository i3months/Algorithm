#include <stdio.h>

int main(){

    for(int i = 0; i<3; i++){
        int a1, a2, a3, a4;
        scanf("%d%d%d%d", &a1, &a2, &a3, &a4);
        int arr[4] = {a1, a2, a3, a4};
        int back = 0;
        int front = 0;
        for(int j = 0; j<4; j++){
             if(arr[j] == 0){
            back++;    
        }else{
            front++;
        }
        }
       

        if(back == 0){
            printf("E\n");
        }else if(back == 1){
            printf("A\n");
        }else if(back == 2){
            printf("B\n");
        }else if(back == 3){
            printf("C\n");
        }else{
            printf("D\n");
        }
    }

    


    
    
}
