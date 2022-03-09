#include <stdio.h>

int main(void)
{

    int N;
    int ans = 0;
    int seq = 0;
    int num;

    scanf("%d", &N);

    for(int i=0; i<N; i++){
        scanf("%d", &num);
        if(num == 1){
            seq++;
            ans = ans + seq;
        }else{
            seq = 0;
        }
    }

    printf("%d",ans);

        
}