#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>


void solve(int a, int b){
    int tmp1 = (b*2) - a;
    int tmp2 = b - tmp1;

    printf("%d %d\n", tmp1, tmp2);
}

int main() {        
    
    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++){
        int a;
        int b;
        scanf("%d %d", &a, &b);

        solve(a,b);
    }
    
    

}
