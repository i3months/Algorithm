#include<stdio.h>

int main(){

    int arr1[11];
    float arr2[11];

    int N;
    scanf("%d", &N);

    for(int i =0; i<N; i++){
        int M;
        scanf("%d", &M);
        
        for(int j = 0; j<M; j++){
            int temp1;
            float temp2;
            scanf("%d", &temp1);
            scanf("%f", &temp2);
            arr1[j] = temp1;
            arr2[j] = temp2;
        }

        int sum = 0;
        float score = 0.0;
        
        for(int k=0; k<M; k++){
            sum = sum + arr1[k];
        }

        for(int k=0; k<M; k++){
            score = score + (arr1[k] * arr2[k]);
        }

        float ans = score / sum;
        printf("%d %.1f\n", sum, ans);
        
    }

    
}