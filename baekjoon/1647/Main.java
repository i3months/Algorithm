import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M;
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st; 

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.add(new Edge(a,b,c));
		}

		Collections.sort(list);

		parent = new int[N + 1];

		for(int i=1; i<N+1; i++){
			parent[i] = i;
		}

		int min = 0;

		ArrayList<Integer> list2 = new ArrayList<>();

		for(int i=0; i<M; i++){
			Edge cur = list.get(i);

			int from = find(cur.from);
			int to = find(cur.to);

			if(!sameParent(from, to)){
				// min += cur.weight;
				list2.add(cur.weight);
				union(cur.from, cur.to);
			}
		}

		Collections.sort(list2);

		for(int i=0; i<list2.size()-1; i++){
			min += list2.get(i);
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