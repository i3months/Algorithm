#include<stdio.h>
#include <string.h> 

int main()
{
    int N;
    scanf("%d", &N);
    
    for(int i=0; i<N; i++){
        int P, M;
        scanf("%d %d", &P, &M);
        int ans = P;
        
        int sit[501];

        for(int j=0; j<501; j++){
            sit[j] = 0;
        }
        
        for(int j=0; j<P; j++){
            int temp;
            scanf("%d", &temp);

            
            if(sit[temp] == 0){
                sit[temp]++;
                ans--;
            }

        }
        printf("%d\n", ans);

    }
    
}
