    #include <stdio.h>

    int main()
    {
        int N;
        int M;
        scanf("%d %d", &N, &M);

        int ans = (N) * (M) - 1;

        if (N == 1 && M == 1)
        {
            printf("0");
        }
        else{
            printf("%d", ans);
        }
    }
