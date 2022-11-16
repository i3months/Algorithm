import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M;
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];                

        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }        

        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++) {
                int a = Integer.parseInt(st.nextToken());

                if(a == 1) {
                    int start = find(i);
                    int end = find(j);

                    if(!sameParent(start, end)) {
                        union(i, j);
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int[] seq = new int[M + 1];

        for(int i=1; i<M+1; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int before = find(seq[1]);

        for(int i=2; i<M+1; i++){
            if(before != find(seq[i])) {
                System.out.println("NO");
                return;
            } 
        }

        System.out.println("YES");
        return;

        // int idx = 1;

		// for(int i=1; i<M + 1; i++) {
		// 	st = new StringTokenizer(br.readLine());

		// 	int a = Integer.parseInt(st.nextToken());
		// 	int b = Integer.parseInt(st.nextToken());
		// 	int c = Integer.parseInt(st.nextToken());

        //     if(a == 1) {
        //         int start = find(idx);
        //         int end = find(i);

        //         if(!sameParent(start, end)) {
        //             union(idx, i);
        //         }
                
        //     }

        

		// 	if(a == 0){
		// 		int start = find(b);
		// 		int end = find(c);

		// 		if(!sameParent(start, end)) {
		// 			union(b, c);
		// 		}
		// 	}

		// 	if(a == 1) {
		// 		int start = find(b);
		// 		int end = find(c);

		// 		if(start == end ) {
		// 			System.out.println("YES");
		// 		}else{
		// 			System.out.println("NO");
		// 		}
		// 	}
		// }

        // for(int i=0; i<list.size(); i++){
        //     Edge cur = list.get(i);

        //     int start = find(cur.start);
        //     int end = find(cur.end);

        //     if(!sameParent(start, end)){
        //         ans += cur.weight;
        //         union(cur.start, cur.end);
        //     }                    
        // }

        // System.out.println(ans);

            
    }

    static int find(int a){
        if(parent[a] == a){
            return a;
        }

        return parent[a] = find(parent[a]); // 경로압축
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){            
            parent[b] = a;
        }
    }

    static boolean sameParent(int a, int b){
        a = find(a);
        b = find(b);

        return a == b;
    }
}

class Edge implements Comparable<Edge>{
    int start, end, weight;

    Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o2){
        Edge o3 = (Edge)o2;

        if(o3.start == this.start && o3.end == this.end && o3.weight == this.weight){
            return true;
        }

        return false;
    }
    
    @Override
    public int compareTo(Edge o2){
        if(weight > o2.weight){
            return 1;
        }else if(weight == o2.weight){
            return 0;
        }else{
            return -1;
        }
 
    }
}