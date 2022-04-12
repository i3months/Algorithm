    #include<stdio.h>
    #include <string.h> 

    int main()
    {
        int N, K;
        scanf("%d %d", &N, &K);

        int arr[10];

        for(int i=0; i<N; i++){
            int temp;
            scanf("%d", &temp);
            arr[i] = temp;
        }

        int cnt = 0;

        for(int i=N-1; i>=0; i--){

            while(1){

                if(arr[i] > K || K == 0){
                    break;
                }else{
                    K = K - arr[i];
                    cnt++;
                }
                
                
            } // end of while 1

        } // end of for i

        printf("%d", cnt);

        

    }
