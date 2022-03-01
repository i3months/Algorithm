import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int ans = 0;	

		int[][] map = new int[N][N];
		boolean[][] runway = new boolean[N][N];

		for(int i=0; i<N; i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		if(L == 1){
			for(int i=0; i<N; i++){
				boolean able = true;	
				for(int j=0; j<N; j++){
					if(j == N-1 && able){
						ans++;
					}
	
					if(j != N-1){
	
						if(map[i][j] == map[i][j+1]){
							continue;
						}else if(map[i][j]+1 == map[i][j+1]){ // 뒤가 더 클때
							if(runway[i][j]){
								able = false;
							}

							runway[i][j] = true;
						}else if(map[i][j]-1 == map[i][j+1]){ // 뒤가 더 작을때

							if(runway[i][j+1]){
								able = false;
							}

							runway[i][j+1] = true;
							continue;
						}else{
							able = false;
						}
	
	
					}
					
				}
			}
		}else{ // L이 1이 아닐 경우
			for(int i=0; i<N; i++){
				boolean able = true;
				int cnt = 0;
	
				for(int j=0; j<N; j++){
					cnt++;
					if(j == N-1 && able){
						ans++;
					}
	
					if(j != N-1){
	
						if(map[i][j] == map[i][j+1]){
							continue;
						}else if(map[i][j]+1 == map[i][j+1]){ // 뒤가 더 클때
							if(cnt >= L){
								for(int k = j; k>j-L; k--){
									if(j-L+1<0){
										able = false;
										break;
									}
									if(runway[i][k]){								
										able = false;
										break;
									}
								}
								for(int k=j; k>j-L; k--){
									if(j-L+1<0){
										able = false;
										break;
									}
									runway[i][k] = true;
								}
								cnt = 0;
								continue;
							}else{
								able = false;
							}
						}else if(map[i][j]-1 == map[i][j+1]){ // 뒤가 더 작을때
							for(int l = j+1; l<j+L; l++){
								if(j+L>N){
									able = false;
									break;
								}
								if(runway[i][l]){
									able = false;
									break;
								}
							}
							int temp_cnt = 1;
							for(int k =j+1; k<j+L; k++){
								if(j+L>N){
									able = false;
									break;
								}
								if(k == N-1){
									able = false;
									break;
								}
								if(map[i][k] == map[i][k+1]){
									temp_cnt++;
									if(temp_cnt >= L){
										for(int l = j+1; l<j+L+1; l++){
											if(j+L>N){
												able = false;
												break;
											}
											runway[i][l] = true;
										}
										cnt = 0;




									}
	
								}
								if(k==j+L-1){
									if(temp_cnt<L){
										able = false;
									}
								}
							}
							
						}else{
							able = false;
						}
	
	
					}
					
				}
			}
		} // row에 대해서 답 갱신



		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				runway[i][j] = false;
			}
		} // 경사로 초기화



		if(L == 1){
			for(int j=0; j<N; j++){
				boolean able = true;	
				for(int i=0; i<N; i++){
					if(i == N-1 && able){
						ans++;
					}
	
					if(i != N-1){
	
						if(map[i][j] == map[i+1][j]){
							continue;
						}else if(map[i][j]+1 == map[i+1][j]){ // 뒤가 더 클때
							if(runway[i][j]){
								able = false;
							}

							runway[i][j] = true;
						}else if(map[i][j]-1 == map[i+1][j]){ // 뒤가 더 작을때

							if(runway[i+1][j]){
								able = false;
							}

							runway[i+1][j] = true;
							continue;
						}else{
							able = false;
						}
	
	
					}
					
				}
			}
		}else{ // L이 1이 아닐 경우
			for(int j=0; j<N; j++){
				boolean able = true;
				int cnt = 0;
	
				for(int i=0; i<N; i++){
					cnt++;
					if(i == N-1 && able){
						ans++;
					}
	
					if(i != N-1){
	
						if(map[i][j] == map[i+1][j]){
							continue;
						}else if(map[i][j]+1 == map[i+1][j]){ // 뒤가 더 클때
							if(cnt >= L){
								for(int k = i; k>i-L; k--){
									if(i-L+1<0){
										able = false;
										break;
									}
									if(runway[k][j]){								
										able = false;
										break;
									}
								}
								for(int k=i; k>i-L; k--){
									if(i-L+1<0){
										able = false;
										break;
									}
									runway[k][j] = true;
								}
								cnt = 0;
								continue;
							}else{
								able = false;
							}
						}else if(map[i][j]-1 == map[i+1][j]){ // 뒤가 더 작을때
							for(int l = i+1; l<i+L; l++){
								if(i+L>N){
									able = false;
									break;
								}
								if(runway[l][j]){
									able = false;
									break;
								}
							}
							int temp_cnt = 1;
							for(int k =i+1; k<i+L; k++){
								if(i+L>N){
									able = false;
									break;
								}
								if(k == N-1){
									able = false;
									break;
								}
								if(map[k][j] == map[k+1][j]){
									temp_cnt++;
									if(temp_cnt >= L){
										for(int l = i+1; l<i+L+1; l++){
											runway[l][j] = true;
										}
										cnt = 0;
						
									}
	
								}
								if(k==i+L-1){
									if(temp_cnt<L){
										able = false;
									}
								}
							}
							
						}else{
							able = false;
						}
	
	
					}
					
				}
			}
		} // column에 대해서 답 갱신	






		System.out.println(ans);

		
	}
}