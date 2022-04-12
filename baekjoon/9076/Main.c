#include<stdio.h>
#include <string.h> 

int main()
{
    int N;
    scanf("%d", &N);
    
    for(int i=0; i<N ;i++){
        int arr[5];

        for(int j=0; j<5; j++){
            int temp;
            scanf("%d", &temp);
            arr[j] = temp;
        }

            for(int k=0; k<5; k++){
            for(int j=0; j<5-1; j++){
                if(arr[j] > arr[j+1]){
                int temp1 = arr[j+1];              
                arr[j+1] = arr[j];
                arr[j] = temp1;
            }
        }
    } // end of bubble sort ascending

  
        // 0 1 2 3 4
        if(arr[3] - arr[1] >=4){
            printf("KIN\n");
        }else{
            int ans = arr[1]+arr[2]+arr[3];
            printf("%d\n", ans);
        }
    }
  
    
}
