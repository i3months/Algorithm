#include <stdio.h>

int main()
{

    int n;
    scanf("%d", &n);

    for(int i=1; i<n+1; i++){
        int a;
        int b;
        scanf("%d %d", &a, &b);
        int c = a+b;

        printf("Case %d: %d\n", i, c);    
    }


}