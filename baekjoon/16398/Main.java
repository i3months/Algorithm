import java.io.*;
import java.util.*;
 
public class Main {
    
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st; 

		int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        
        int M = 0;


		for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] != 0 && !visit[i][j]){
                    list.add(new Edge(i,j,map[i][j]));
                    visit[i][j] = true;
                    visit[j][i] = true;
                    M++;
                }
            }
        }

        
        
		Collections.sort(list);

		parent = new int[N + 1];

		for(int i=1; i<N+1; i++){
			parent[i] = i;
		}

		long min = 0;		

		for(int i=0; i<M; i++){
			Edge cur = list.get(i);

			int from = find(cur.from);
			int to = find(cur.to);

			if(!sameParent(from, to)){
				min += cur.weight;				
				union(cur.from, cur.to);
			}
		}


		System.out.println(min);
		
    }

	static int find(int val){
		if(parent[val] == val) return val;
		return parent[val] = find(parent[val]);
	}

	static void union(int val1, int val2){
		val1 = find(val1);
		val2 = find(val2);

		if(val1 != val2){
			parent[val2] = val1;
		}
	}

	static boolean sameParent(int val1, int val2){
		return find(val1) == find(val2);
	}
}

class Edge implements Comparable<Edge>{
	int from, to, weight;

	Edge(int from, int to, int weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o2){
		if(weight > o2.weight){
			return 1;
		}else if(weight < o2.weight){
			return -1;
		}else{
			return 0;
		}
		// return weight > o2.weight ? 1 : -1;
	}
}