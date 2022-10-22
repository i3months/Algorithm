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

        double[][] arr = new double[N+1][2];

		for(int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Double.parseDouble(st.nextToken());
			arr[i][1] = Double.parseDouble(st.nextToken());
		}

		for(int i=1; i<N+1; i++){
			for(int j=i+1; j<N+1; j++){
				double tmp1 = arr[i][0] - arr[j][0];
				tmp1 = tmp1 * tmp1;
				double tmp2 = arr[i][1] - arr[j][1];
				tmp2 = tmp2 * tmp2;
				
				double cost = Math.sqrt(tmp1 + tmp2);				
				list.add(new Edge(i,j,cost));
			}
		}

        
        
		Collections.sort(list);

		parent = new int[N + 1];

		for(int i=1; i<N+1; i++){
			parent[i] = i;
		}

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }


		double min = 0;		

		for(int i=0; i<list.size(); i++){
			Edge cur = list.get(i);

			int from = find(cur.from);
			int to = find(cur.to);

			if(!sameParent(from, to)){
				min += cur.weight;				
				union(cur.from, cur.to);
			}
		}


		System.out.println(String.format("%.2f", min));
		
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