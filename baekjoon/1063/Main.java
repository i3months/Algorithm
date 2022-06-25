import java.util.*;
import java.io.*;
import java.math.*;

public class Main {		
	static int[][] dir = { {1,0}, {-1,0}, {0,-1}, {0,1}, {1,1}, {-1,1}, {1,-1}, {-1,-1} };
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			String king = st.nextToken();
			String stone = st.nextToken();
			int N = Integer.parseInt(st.nextToken());

			int k_r = king.charAt(0) - 'A';
			int k_c = king.charAt(1) - '0';

			int 	s_r = stone.charAt(0) - 'A';
			int s_c = stone.charAt(1) - '0';

			for(int i=0; i<N; i++){
				String move = br.readLine();

				int idx = 0;

				if(move.equals("R")) {
					idx =  0;
				}else if(move.equals("L")) {
						idx =  1;
				}else if(move.equals("B")) {
						idx =  2;
				}else if(move.equals("T")) {
						idx =  3;
				}else if(move.equals("RT")) {
						idx =  4;
				}else if(move.equals("LT")) {
						idx =  5;
				}else if(move.equals("RB")) {
						idx =  6;
				}else if(move.equals("LB")) {
						idx =  7;
				}

				

				int dk_r = k_r + dir[idx][0];
				int dk_c = k_c + dir[idx][1];

				if(dk_r == s_r && dk_c == s_c){ 
					int ds_r = s_r + dir[idx][0];
					int ds_c = s_c + dir[idx][1];					

					if(ds_r >= 0  && ds_r < 8 && ds_c >= 1 && ds_c <= 8){
						k_r = dk_r;
						k_c = dk_c;

						s_r = ds_r;
						s_c = ds_c;											
					}
				}else{
					if(dk_r >= 0  && dk_r < 8 && dk_c >= 1 && dk_c <= 8){
						k_r = dk_r;
						k_c = dk_c;						
					}
				}			
				
				//System.out.println("tmp : " + (char)(dk_r + 'A') + "" + dk_c);
			  //System.out.println("tmp : " + (char)(s_r + 'A') + "" + s_c);
					
			}

			System.out.println((char)(k_r + 'A') + "" + k_c);
			System.out.println((char)(s_r + 'A') + "" + s_c);
	}
}