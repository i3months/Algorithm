import java.util.*;
import java.io.*;

public class Main {

	static int[] limit = new int[3];
	static boolean[] possible;
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				

		StringTokenizer st =new StringTokenizer(br.readLine());

		for(int i=0; i<3; i++){
			limit[i] = Integer.parseInt(st.nextToken());
		} 
		
		visit = new boolean[300][300][300];
		possible = new boolean[300];
		


		bfs(0,0,limit[2]); // start with full C

		for(int i=0; i<201; i++){
			if(possible[i]){
				System.out.print(i + " ");
			}
		}

	}

	static void bfs(int x1, int x2, int x3){

		Queue<State> q = new LinkedList<>();

		visit[x1][x2][x3] = true; // check state a b c

		int temp[] = {x1,x2,x3};

		q.add(new State(temp));

		while(!q.isEmpty()){
			State tmp = q.poll();

			if(tmp.bucket[0] == 0){
				possible[tmp.bucket[2]] = true; // target : a is empty -> capacity of c. check a is empty
			}

			for(int from = 0; from < 3; from++){
				for(int to = 0; to < 3; to++){

					if(from == to){
						continue; // same condition ignore
					}

					State next = tmp.move(from, to, limit);

					if(!visit[next.bucket[0]][next.bucket[1]][next.bucket[2]]){ // check state a b c is overlap
						visit[next.bucket[0]][next.bucket[1]][next.bucket[2]] = true;
						q.add(next);
					}

				}
			}
		}
	}
	
}

class State{
	int[] bucket;
	
	State(int[] temp){
		bucket = new int[3];
		for(int i=0; i<3; i++){
			bucket[i] = temp[i];
		} 	 
	}

	State move(int from, int to, int[] limit){
		int[] nBucket = {bucket[0], bucket[1], bucket[2]};

		if(bucket[from] + bucket[to] <= limit[to]){
			nBucket[to] = nBucket[from] + nBucket[to];
			nBucket[from] = 0;
		}else{
			nBucket[from] = nBucket[from] - (limit[to] - nBucket[to]);
			nBucket[to] = limit[to];
		}

		return new State(nBucket);
	}
}