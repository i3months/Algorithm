#include <stdio.h>

int main()
{

    int out[10];
    int in[10];

    for(int i = 0; i<10; i++){
        scanf("%d", &out[i]);
        scanf("%d", &in[i]);
    }


     int max = -out[0] + in[0];
        int compare = 0;

        for(int i=0; i<10; i++){
            compare = compare -out[i] + in[i];

            if(max < compare){
                max = compare;
            }        

        }

    printf("%d", max);
      

}