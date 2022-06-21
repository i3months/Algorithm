import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Traffic[] arr = new Traffic[N];

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			arr[i] = new Traffic(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int locate = 0;
		int time = 0;
		int idx = 0;
		
		while(true){
			time++;
			locate++;

			if(locate == L){
				break;
			}			

			if(idx == N){
				continue;
			}else{
				if(locate == arr[idx].dir){				
					int cycle = time % (arr[idx].green + arr[idx].red);
					if(cycle <= arr[idx].red){
						time = time + (arr[idx].red - cycle);
					}
					idx++;
				}			
			}


		}

		System.out.println(time);
		

	}
}	

class Traffic{
	int dir;
	int red;
	int green;

	Traffic(int a, int b, int c){
		dir = a;
		red = b;
		green = c;
	}
}