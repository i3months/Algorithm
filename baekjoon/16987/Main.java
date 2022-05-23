import java.util.*;
import java.io.*;

public class Main {	

  static int N = 0;
	static int cnt = 0;
	static Egg[] egg;
	static int max = 0;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		N = Integer.parseInt(br.readLine());

		egg = new Egg[N];
		
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			egg[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		solve(0);
		
		System.out.println(max);

		
	}

	static void solve(int k){
		if(k == N){
			max = Math.max(max, cnt);
			return;
		}

		if(egg[k].durability <= 0 || cnt == N-1){
			solve(k+1);
			return;
			// 들고있는게 깨져있거나 싹다 깨졌으면 다음으로
		}

		for(int i=0; i<N; i++){
			if(i == k || egg[i].durability <= 0){
				continue;
			}
			// k번째 계란이 내가 들고있는거. i번째 계란이 내가 치려는거.
			// 치려는게 깨져있으면 넘어가

			egg[k].durability = egg[k].durability - egg[i].weight;
			egg[i].durability = egg[i].durability - egg[k].weight;

			if(egg[i].durability <= 0){
				cnt++;
			}
			if(egg[k].durability <= 0){
				cnt++;
			}

			solve(k+1);
			
			if(egg[i].durability <= 0){
				cnt--;
			}
			if(egg[k].durability <= 0){
				cnt--;
			}
			egg[k].durability = egg[k].durability + egg[i].weight;
			egg[i].durability = egg[i].durability + egg[k].weight;

		}

	}
}

class Egg{
	int durability = 0;
	int weight = 0;

	Egg(int a, int b){
		durability = a;
		weight = b;
	}
}