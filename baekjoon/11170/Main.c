    #include<stdio.h>
    #include <string.h> 

    int main()
    {
        int N;
        scanf("%d", &N);

        for(int i=0; i<N; i++){
            int start, end;
            scanf("%d %d", &start, &end);

            int count = 0;

            for(int j = start; j<=end; j++){
                char arr[1000001];
                sprintf(arr, "%d", j);
                for(int k=0; k<strlen(arr); k++){
                    if(arr[k] == '0'){
                        count++;
                    }
                }
            }
            printf("%d\n", count);
        
        }

    }
