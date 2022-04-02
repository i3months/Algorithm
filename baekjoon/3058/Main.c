#include <stdio.h>
 
int main() {
 
    int a,n;                        
    scanf("%d",&n);                 
 
    for(int i=0; i<n; i++){         
 
        int sum=0;                  
        int min=101;         
        for(int i=0; i<7; i++){
            scanf("%d",&a);
            if(a%2==0){        
                sum+=a;
 
                if(min>a)
                min=a;
            }
        }
        printf("%d %d\n",sum,min);
    }
 
    return 0;
}
