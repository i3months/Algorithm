  #include <stdio.h>
  int main()
  {
    int N;
    int i;
    double A,B;

    scanf("%d", &N);

    for(i = 0; i<N; i++)
    {
      scanf("%lf %lf", &A, &B);
      printf("%.0lf\n", (A*A/2) / (B*B/2));
    }



  }