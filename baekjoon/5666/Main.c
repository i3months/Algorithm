#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    double a;
    double b;

    
    while(scanf("%lf %lf", &a, &b) != EOF){    
        double ans = a / b;

        printf("%.2lf\n", ans);
        
    }

}