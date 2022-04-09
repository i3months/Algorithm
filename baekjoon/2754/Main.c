#include <stdio.h>

int main(){
    char str[3];

    scanf("%s", str);

    if(str[0] == 'A' && str[1] == '+'){
        printf("4.3");
    }else if(str[0] == 'A' && str[1] == '0'){
        printf("4.0");
    }else if(str[0] == 'A' && str[1] == '-'){
        printf("3.7");
    }else if(str[0] == 'B' && str[1] == '+'){
        printf("3.3");
    }else if(str[0] == 'B' && str[1] == '0'){
        printf("3.0");
    }else if(str[0] == 'B' && str[1] == '-'){
        printf("2.7");
    }else if(str[0] == 'C' && str[1] == '+'){
        printf("2.3");
    }else if(str[0] == 'C' && str[1] == '0'){
        printf("2.0");
    }else if(str[0] == 'C' && str[1] == '-'){
        printf("1.7");
    }else if(str[0] == 'D' && str[1] == '+'){
        printf("1.3");
    }else if(str[0] == 'D' && str[1] == '0'){
        printf("1.0");
    }else if(str[0] == 'D' && str[1] == '-'){
        printf("0.7");
    }else{
        printf("0.0");
    }


}