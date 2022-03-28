#include <stdio.h>

int main(void) {
    int a[5];
		int ans = 0;

    for (int i=0; i<5; i++){
			scanf("%d", &a[i]);
		}

    for (int i=0; i<4; i++) {
        for (int j=0; j<4-i; j++) {
            if (a[j]>a[j+1]) {
                int t=a[j];
                a[j]=a[j+1];
                a[j+1]=t;
            }
        }
    }// 정렬

    for (int i=0; i<5; i++) {
        for (int j=i+1; j<5; j++) {
            for (int k=j+1; k<5; k++) {
                if (a[i]+a[j]>a[k]) ans++;
            }
        }
    } // 갱신


    printf("%d", ans);
}