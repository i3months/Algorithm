#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>


void solve(int a, int b){
    int tmp1 = a / b;
    int tmp2 = a % b;
    printf("%d %d / %d\n", tmp1, tmp2, b);
}

int main() {        
    
    while(1){
        int a;
        int b;
        scanf("%d %d", &a, &b);

        if(a == 0 && b == 0){
            break;
        }

        solve(a,b);
    }
    
    

}
