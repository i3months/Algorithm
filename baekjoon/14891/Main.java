import java.util.*;
import java.io.*;

public class Main {

	static int[] wheel = new int[4]; // 이진수로 톱니바퀴 4개를 다룬다. 배열로 저장함
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<4; i++){
			wheel[i] = Integer.parseInt(br.readLine(), 2); // 2진수로 톱니바퀴 4개를 다룬다.
		}
		
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int v = Integer.parseInt(st.nextToken()); // 톱니바퀴 번호 0 1 2 3
			int dir = Integer.parseInt(st.nextToken()); // 회전방향 1은 시계 -1은 반시계
			rotate(v-1,dir);

		}

		int score = 0;
		
		for(int i=0; i<4; i++){  // 회전을 마친 후 점수계산
			if((wheel[i] & (1<<7)) == 0){
				
			}else{
				switch(i){
					case 0:
					score = score + 1;
					break;

					case 1:
					score = score + 2;
					break;

					case 2:
					score = score + 4;
					break;

					case 3:
					score = score + 8;
					break;
					
					
				}
			}
		}
		System.out.println(score);
		

	}
	static void rotate(int v, int dir){
		int[] direction = new int[4]; // -1일때는 반시계 0일때는 회전 안함 1일때는 시계 배열 기본값은 0이라서 지정해 주지 않으면 회전하지 않음
		direction[v] = dir;

		for(int i = v; i>0; i--){ // 회전하는 톱니바퀴를 기준으로 좌측에 있는 톱니바퀴들을 검사함. 
			if(polar(i-1,i)){        // 회전이 연쇄적으로 이어지니까..
				break;                // 극성이 동일하면 회전할 필요가 없으니 break
			}
			direction[i-1] = direction[i] * -1; // 극성이 반대일 경우 반대 방향으로 회전함. 그래서 -1을 곱해줌
		}

		for(int i=v; i<3; i++){ // 이 부분은 오른쪽으로 검사하는 부분
			if(polar(i,i+1)){
				break;
			}
			direction[i+1] = direction[i] * -1;
		}	

		for(int i=0; i<4; i++){
			if(direction[i]==1){ // 회전방향을 저장해둔 배열의 값이 1이면 시계방향으로 회전
				rotateclockwise(i);
			}
			if(direction[i]==-1){
				rotatecounterclockwise(i); // -1이면 시계 반대방향으로 회전
			}
		}
		
	}

	static boolean polar(int a, int b){
		
		int polar1 = 0;
		if((wheel[a] & (1 << 5)) > 0){ // 톱니바퀴에 대해서 00100000 과 and 연산을 진행함
			polar1 = 1;                  // 배열로 치면 2번 인덱스를 구할 수 있다.
		}else{												 // 둘다 1 일때 결과가 1이 되니 0과 대소를 비교함. 
			polar1 = 0;
		}

		int polar2 =0;
		if((wheel[b] & (1 << 1)) > 0){ // 오른쪽 톱니바퀴에 대해서 00000010 과 and 연산을 진행함
			polar2 = 1;                  // 배열로 치면 6번 인덱스를 구할 수 있다.
		}else{
			polar2 = 0;
		}

		return polar1 == polar2;
	}

	static void rotateclockwise(int v){
		if((wheel[v] & 1) > 0){       // 배열로 치면 7번 인덱스를 구한다. 1일때 실행
			int temp1 = wheel[v] >> 1; // 1일때 실행하는 이유는 0으로 덮어지기 때문
			wheel[v] = temp1;

			int temp2 = wheel[v] | (1<<7); // 사라진 1을 채워줘야 함. 10000000과 or 연산을 하자
			wheel[v] = temp2;
		}else{
			int temp3 = wheel[v] >> 1; // 1이 아니면 그냥 하면 됨
			wheel[v] = temp3;
		}
	}

	static void rotatecounterclockwise(int v){ // 위와 마찬가지
		if((wheel[v] & (1<<7)) > 0){
			int temp1 = wheel[v] << 1;
			wheel[v] = temp1;

			int temp2 = wheel[v] | 1;
			wheel[v] = temp2;
		}else{
			int temp3 = wheel[v] << 1;
			wheel[v] = temp3;
		}
	}

	
}