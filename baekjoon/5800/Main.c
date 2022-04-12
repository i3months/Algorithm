#include<stdio.h>
#include <string.h> 

int main()
{
    int N;
    scanf("%d", &N);

    for(int i=1; i<=N; i++){
        int M;
        scanf("%d", &M);

        int arr[51];

        for(int j=0; j<M; j++){
            int temp;
            scanf("%d", &temp);
            arr[j] = temp;
        }   

        int min = 100;
        int max = 0;

        for(int j=0; j<M; j++){
            if(max < arr[j]){
                max = arr[j];
            }
            if(min > arr[j]){
                min = arr[j];
            }
        }

        for(int j = 0; j<M; j++){
            for(int k =0; k<M-1; k++){
                if(arr[k] > arr[k+1]){
                    int temp = arr[k+1];
                    arr[k+1] = arr[k];
                    arr[k] = temp;
                }
            }
        }


        int gap = 0;

        for(int j = 0; j<M-1; j++){
            if(arr[j+1] - arr[j] > gap){
                gap = arr[j+1] - arr[j];
            }
        }



        printf("Class %d\nMax %d, Min %d, Largest gap %d\n", i, max, min, gap);
    }

}
