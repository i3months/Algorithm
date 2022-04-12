#include<stdio.h>
#include <string.h> 

int main()
{
    int arr1[10];
    int arr2[10];

    for(int i=0; i<10; i++){
        int temp;
        scanf("%d", &temp);
        arr1[i] = temp;
    }

    for(int i=0; i<10; i++){
            int temp;
            scanf("%d", &temp);
            arr2[i] = temp;
    }

    for(int i=0; i<10; i++){
        for(int j=0; j<9; j++){
            if(arr1[j] > arr1[j+1]){
                int temp = arr1[j+1];
                arr1[j+1] = arr1[j];
                arr1[j] = temp;
            }
        }
    }

        for(int i=0; i<10; i++){
            for(int j=0; j<9; j++){
                if(arr2[j] > arr2[j+1]){
                    int temp = arr2[j+1];
                    arr2[j+1] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }



        int ans1 = arr1[9] + arr1[8] + arr1[7];
        int ans2 = arr2[9] + arr2[8] + arr2[7];
        printf("%d\n", ans1);
        printf("%d\n", ans2);
    

}
