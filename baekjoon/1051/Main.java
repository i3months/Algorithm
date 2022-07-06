import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[][] arr = new int[N][M];
		int max = 0;
		int row = 0;
		int col = 0;
		boolean flag = true;
		
		
		for(int i=0; i<N; i++) {
			String str = scan.next();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
	
		 
		 
		while(true) {
			int area = 0;
			if(!flag)
				break;
			
			for(int i=0; i<N-1; i++) {
				for(int j=0; j<M-1; j++) {
										
					if(row + i >=N || col + j >= M) {
						flag = false;
						break;
					}
										
					 
					 
					 
					 
					 
					if(arr[i][j] == arr[i][j+col] && arr[i][j] == arr[i+row][j] && arr[i][j] == arr[i+row][j+col]) {						
						int width = (Math.abs(j-i)) + 1;
						area = width * width;
					}
				}
			}
			
			max = Math.max(max, area);
			row ++;
			col ++;
		}
		System.out.println(max);
		scan.close();
	}

}