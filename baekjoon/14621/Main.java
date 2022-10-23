import java.io.*;
import java.util.*;
 
public class Main {
    
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine()); 

		int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] arr = new char[N + 1];
        int[][] arr2 = new int[M + 1][3];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            if(arr[from] == 'M' && arr[to] == 'W'){
                list.add(new Edge(from, to, weight));
            }

            if(arr[from] == 'W' && arr[to] == 'M'){
                list.add(new Edge(from, to, weight));
            }

        }
                
        
		Collections.sort(list);

		parent = new int[N + 1];

		for(int i=1; i<N+1; i++){
			parent[i] = i;
		}

		int min = 0;	
        int start = 0;	

        ArrayList<Integer>[] list2 = new ArrayList[N + 1];
        for(int i=0; i<N+1; i++) list2[i] = new ArrayList<>();

		for(int i=0; i<list.size(); i++){
			Edge cur = list.get(i);

			int from = find(cur.from);
			int to = find(cur.to);

			if(!sameParent(from, to)){
                if(start == 0) start = from;
                list2[from].add(to);     
                list2[to].add(from);           
				min += cur.weight;				
				union(cur.from, cur.to);
			}
		}

        //
        boolean[] visit = new boolean[N + 1];
        visit[start] = true;
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();            
                
            for(int k : list2[cur]){
                if(!visit[k]){
                    visit[k] = true;
                    cnt++;
                    q.add(k);
                }
            }
        }
        //        

        if(cnt != N) System.out.println(-1);
        else System.out.println(min == 0 ? -1 : min);
		
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
	int from, to;
	double weight;

	Edge(int from, int to, double weight){
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
	}
}