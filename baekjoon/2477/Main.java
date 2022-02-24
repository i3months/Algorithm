import java.util.*;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

		int k = Integer.parseInt(br.readLine());

		int[] dir_arr = new int[5];
		int[] val_arr = new int[6];

		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
			
		for(int i=0; i<6; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			dir_arr[dir] ++;
			val_arr[i] = val;
			if(dir == 3  || dir == 4){
				pq1.add(val);
			}else if(dir == 1  || dir == 2 ){
				pq2.add(val);
			}
		}

		int max_height = pq1.poll();
		int max_width = pq2.poll();

		int w = 0;
		int h = 0;
		boolean check = false;

		for(int i=0; i<6; i++){
			int compare1 = 0;
			int compare2 = 0;

			if(i == 0){
				compare1 = 5;
				compare2 = i+1;
			}else if(i == 5){
				compare1 = i-1;
				compare2 = 0;
			}else{
				compare1 = i-1;
				compare2 = i+1;
			}

			if(val_arr[compare1] + val_arr[compare2] ==max_height || (val_arr[compare1] + val_arr[compare2] ==max_width)){
				if(val_arr[compare1] + val_arr[compare2] ==max_height ){
					if(w == 0){
						w = val_arr[i];
					}else{
						h = val_arr[i];
					}
			
					
				}else{
					h = val_arr[i];
				}
			}
		}


		int ans = ((max_height * max_width) - (w*h))*k;
		System.out.println(ans);

	}
}

		
