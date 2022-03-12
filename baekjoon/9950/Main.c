#include <stdio.h>

int main(){

    while(1){
        int l;
        int w;
        int a;

        scanf("%d%d%d", &l, &w, &a);

        if(l == 0 && w == 0 && a == 0){
            break;
        }

        if(l == 0){
            l = a / w;
        }

        if(w == 0){
            w = a / l;
        }

        if(a == 0){
            a = w * l;
        }

        printf("%d %d %d\n", l,w,a);
    }
    
    
}
