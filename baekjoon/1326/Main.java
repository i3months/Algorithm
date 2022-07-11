import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N+1];
		boolean[] visit = new boolean[N+1];

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		Queue<Rock> q = new LinkedList<>();

		visit[A] = true;
		q.add(new Rock(A, 0));

		while(!q.isEmpty()){
			Rock rock = q.poll();

			int locate = rock.idx;
			int cnt = rock.cnt;

			if(locate == B){
				System.out.println(cnt);
				return;
			}

			int idx = 0;

			while(true){
        idx++;
				int next = locate + arr[locate] * idx;
				
				if(next > N){
					break;
				}

				if(!visit[next]){
					visit[next] = true;
					q.add(new Rock(next, cnt + 1));
				}
			}

      int idx2 = 0;
      while(true){
        idx2++;
        int next = locate - arr[locate] * idx2;

        if(next <= 0){
          break;
        }

        if(!visit[next]){
					visit[next] = true;
					q.add(new Rock(next, cnt + 1));
				}
      }

			
		}

		System.out.println(-1);
		
		

	}
}

class Rock{
	int idx, cnt;

	Rock(int a, int b){
		idx = a;
		cnt = b;
	}
}