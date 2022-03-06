#include<stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    int last = 1;
    int d = 2;

    for (int i = 1; i <= N; i++) {
        if (i % d == 0) {
            last = i;
            d *= 2;
        }
    }
    printf("%d", last);


    return 0;
}