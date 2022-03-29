#include <stdio.h>

int main(){
    int t1, t2, t3, t4, t5, t6;
    int start, end, t, h, m, s;

    for(int i = 0; i < 3; i++){
        scanf("%d %d %d %d %d %d", &t1, &t2, &t3, &t4, &t5, &t6);
        start = (t1*3600)+(t2*60)+t3;
        end = (t4*3600)+(t5*60)+t6;
        t = end - start;
        h = t/3600;
        m = (t%3600)/60;
        s = (t%3600)%60;
        
        printf("%d %d %d\n", h, m, s);
    }
    return 0;
}