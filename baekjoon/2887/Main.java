import java.io.*;
import java.util.*;
 
public class Main {
    
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st; 

		int N = Integer.parseInt(br.readLine());
             
        Planet[] planet_arr = new Planet[N];

		for(int i=1-1; i<N+1-1; i++){            
			st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            planet_arr[i] = new Planet(i+1, a, b, c);			                        
		}
        
        Arrays.sort(planet_arr, (o1, o2) -> o1.a - o2.a);
        
        for(int i=0; i<N-1; i++){
            list.add(new Edge(planet_arr[i].idx, planet_arr[i+1].idx, Math.abs(planet_arr[i].a - planet_arr[i+1].a)));
        }

        Arrays.sort(planet_arr, (o1, o2) -> o1.b - o2.b);
        
        for(int i=0; i<N-1; i++){
            list.add(new Edge(planet_arr[i].idx, planet_arr[i+1].idx, Math.abs(planet_arr[i].b - planet_arr[i+1].b)));
        }

        Arrays.sort(planet_arr, (o1, o2) -> o1.c - o2.c);
        
        for(int i=0; i<N-1; i++){
            list.add(new Edge(planet_arr[i].idx, planet_arr[i+1].idx, Math.abs(planet_arr[i].c - planet_arr[i+1].c)));
        }

        
        
        
		Collections.sort(list);

		parent = new int[N + 1];

		for(int i=1; i<N+1; i++){
			parent[i] = i;
		}

		int min = 0;		

		for(int i=0; i<list.size(); i++){
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

class Planet{
    int idx, a, b, c;

    Planet(int idx, int a, int b, int c){
        this.idx=idx;this.a=a;this.b=b;this.c=c;
    }
}

class Edge implements Comparable<Edge>{
	int from, to;
	int weight;

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