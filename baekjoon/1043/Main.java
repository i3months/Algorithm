import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer> truth = new ArrayList<>();
		ArrayList<Integer>[] party = new ArrayList[M];

		st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());

		for(int i=0; i<K; i++){
			truth.add(Integer.parseInt(st.nextToken()));
		}

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken());

			party[i] = new ArrayList<>();

			for(int j=0; j<L; j++){
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		Queue<Integer> q = new LinkedList<>();

		int[] partychk = new int[M];
		int[] truthchk = new int[N+1];

		int ans = M;

		for(int i=0; i<K; i++){
			q.add(truth.get(i));
			truthchk[truth.get(i)] = 1;
		}

		while(!q.isEmpty()){
			int tmp = q.poll();

			for(int i=0; i<M; i++){
				if(partychk[i] == 1){ // 이미 확인한 파티인가?
					continue;
				}

				if(!party[i].contains(tmp)){ // 파티 내부에 진실을 아는애가 있는가?
					continue;
				}

				for(int j=0; j<party[i].size(); j++){ // 한명한테 구라를 두 번 이상 칠 수는 없다.
					int next = party[i].get(j);

					if(truthchk[next] == 1){
						continue;
					}

					truthchk[next] = 1;
					q.add(next);
				}

				partychk[i] = 1;
				ans--;
			}
		}

		System.out.println(ans);
	}
}