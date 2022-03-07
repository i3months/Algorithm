#include <stdio.h>

int main()
{
	int x_max = -10000;
	int x_min = 10000;
	int y_max = -10000;
	int y_min = 10000;
	int x, y;
	int n = 0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d %d", &x, &y);
		if (x_max < x)
			x_max = x;
		if (y_max < y)
			y_max = y;
		if (x_min > x)
			x_min = x;		
		if (y_min > y)
			y_min = y;
	}

	printf("%d", (x_max-x_min)*(y_max-y_min));
	return(0);
}