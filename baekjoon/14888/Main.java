import java.io.*;
import java.util.*;

public class Main {

	static int N, max, min;
	static StringBuilder sb = new StringBuilder();
	static int[] nums, operators, order;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		max = -2000000000;
		min = 2000000000;

		nums = new int[N+1]; // 0번째 인덱스는 사용하지 않음
		operators = new int[5]; // 연산자는 + - x % 4개임
		order = new int[N+1]; // 연산자를 담을 배열

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for(int i=1; i<N+1; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");

		for(int i = 1; i<5; i++){
			operators[i] = Integer.parseInt(st.nextToken());
		}


		sol(1); // 탐색은 1부터 진행함

		sb.append(max).append("\n").append(min);
		System.out.println(sb);
		
	}

	static void sol(int k){
		// 연산자들을 저장함. operator배열에 저장한 연산자들을 order배열에다가 저장.
		if(k == N){ // 다 찾은 경우. 모든 연산자들을 순서대로 나열한 경우.

			// 만들어진 식에 맞게 계산 진행. 따로 함수화해서 진행한다.
			int value = calculate();
			max = Math.max(max,value);
			min = Math.min(min,value);

		}else{
			for(int cand = 1; cand<=4; cand++){
				if(operators[cand] >= 1){
					// 연산자가 존재하면 사용하고 order배열에 해당 연산자를 넣어줌
					operators[cand] --;
					order[k] = cand;
					sol(k+1);
					// 다음 연산을 찾기 위해 초기화.
					operators[cand]++;
					order[k] = 0;
				}
			}
		}
	
	}

	static int calculate(){
		// 식을 계산해주는 함수

		int value = nums[1];
		for(int i=1; i<= N-1; i++){

			if(order[i] == 1){
				value = value + nums[i+1];
			}

			if(order[i] == 2){
				value = value - nums[i+1];
			}

			if(order[i] == 3){
				value = value * nums[i+1];
			}

			if(order[i] == 4){
				value = value / nums[i+1];
			}

			
		}
		return value;
	}
}