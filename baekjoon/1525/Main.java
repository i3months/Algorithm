import java.util.*;
import java.io.*;
import java.math.*;

class Main {
    static String target = "123456780";
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String start = "";

		for(int i=0;i <3; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++){
				start += st.nextToken();
			}
		}		

		hm.put(start, 0);
        System.out.println(bfs(start));
		// System.out.println(start);
    }

	static int bfs(String start){
		Queue<String> q = new LinkedList<>();

		q.add(start);

		while(!q.isEmpty()){
			String cur = q.poll();

			int cnt = hm.get(cur);

			if(cur.equals(target)){
				return cnt;
			}

			int zeroPosition = cur.indexOf('0');
			int r = zeroPosition / 3;
			int c = zeroPosition % 3;
			
			
			for(int i=0; i<4; i++){
				int nextR = r + dr[i];
				int nextC = c + dc[i];

				if(nextR <= -1 || nextR >= 3 || nextC <= -1 || nextC >= 3) continue;

				int nextPosition = nextR * 3 + nextC;
				char tmp = cur.charAt(nextPosition);
				
				String next = cur.replace(tmp, '=');
				next = next.replace('0', tmp);
				next = next.replace('=', '0');

				if(!hm.containsKey(next)){
					q.add(next);
					hm.put(next, cnt + 1);
				}
			}
		}

		return -1;

	}
}
