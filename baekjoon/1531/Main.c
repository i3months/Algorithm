#include <stdio.h>

int main() {

  int N, M;
  scanf("%d %d", &N, &M);

  int map[101][101];

  for(int i=0; i<101; i++){
    for(int j=0; j<101; j++){
      map[i][j] = 0;
    }
  }

  int ans = 0;

  for(int i=0; i<N; i++){
    int a,b,c,d;
    scanf("%d %d %d %d", &a, &b, &c, &d);    

    for(int j=b; j<d+1; j++){
      for(int k=a; k<c+1; k++){
        map[j][k]++;
        if(map[j][k] == M + 1){
          ans++;
        }
      }
    }
  }

  printf("%d", ans);

}