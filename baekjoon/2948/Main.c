#include <stdio.h>
#include <string.h>

int main()
{
    int month[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    char * ans[7] = {
      "Sunday",
      "Monday",
      "Tuesday",
      "Wednesday",
      "Thursday",
      "Friday",
      "Saturday"
    };

    int x,y;
    scanf("%d %d", &y, &x);

    int sum = 0;
    for(int i=1; i<x; i++){
      sum = sum + month[i];
    }
    sum = sum + y+3;

    int temp = sum % 7;

    printf("%s", ans[temp]);
    
}
