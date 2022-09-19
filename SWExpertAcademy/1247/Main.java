import java.io.*;
import java.util.*;

public class Main {			

	static int N;
	static Locate company, home;
	static Locate[] client;
	static int[] select;
	static boolean[] visit;
	static int min = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								

		int TC = Integer.parseInt(br.readLine());

		int cnt = 0;
		StringBuilder sb = new StringBuilder();		

		while(TC-- >0){
			cnt++;
			min = 987654321;

			N = Integer.parseInt(br.readLine());
			select = new int[N + 1];
			visit = new boolean[N + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			company = new Locate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Locate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			client = new Locate[N + 1];

			int a = st.countTokens();			

			int count = 1;

			for(int i=0; i<a; i+=2){
				client[count] = new Locate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				count++;
			}

			bt(1);

			sb.append("#" + cnt + " " + min + "\n");
			

		}

		System.out.println(sb);
		
	}

	static void bt(int depth){
		if(depth == N + 1){

			// for(int i=1; i<N+1; i++){
			// 	System.out.print(select[i] + " ");
			// }System.out.println();

			int tmp = Math.abs(company.r - client[select[1]].r) + Math.abs(company.c - client[select[1]].c);

			for(int i=2; i<N+1; i++){
				tmp += Math.abs(client[select[i-1]].r - client[select[i]].r) + Math.abs(client[select[i-1]].c - client[select[i]].c);
			}

			tmp += Math.abs(client[select[N]].r - home.r) + Math.abs(client[select[N]].c - home.c);

			min = Math.min(min, tmp);

			return;
		}

		for(int i=1; i<N+1; i++){
			if(!visit[i]){
				visit[i] = true;
				select[depth] = i;				
				bt(depth + 1);
				visit[i] = false;
			}	
		}
		

	}
}

class Locate{
	int r, c;

	Locate(int r, int c){
		this.r = r;
		this.c = c;
	}
}