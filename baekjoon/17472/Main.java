import java.io.*;
import java.util.*;
 
public class Main {
    
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st; 

		st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
             
        boolean[][] visit = new boolean[N][M];
        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){                
                if(map[i][j] != 0 && !visit[i][j]){
                    cnt++;
                    Queue<Locate> q = new LinkedList<>();
                    
                    q.add(new Locate(i,j));
                    map[i][j] = cnt;
                    visit[i][j] = true;

                    while(!q.isEmpty()){
                        Locate cur = q.poll();
                        
                        for(int a=0; a<4; a++){
                            int nextR = cur.r + dr[a];
                            int nextC = cur.c + dc[a];

                            if(nextR >= N || nextR <= -1 || nextC >= M || nextC <= -1) continue;
                            if(visit[nextR][nextC]) continue;
                            if(map[nextR][nextC] == 0) continue;

                            visit[nextR][nextC] = true;
                            map[nextR][nextC] = cnt;
                            q.add(new Locate(nextR, nextC));
                            
                        }
                    }
                    
                }
            }
        }

        // for(int i=0; i<N; i++){
        //     for(int j=0; j<M; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }        

        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0){
                    
                    for(int a=0; a<4; a++){
                        int count = 0;
                        int curR = i;
                        int curC = j;

                        int before = map[curR][curC];

                        while(true){
                            curR += dr[a];
                            curC += dc[a];      
                            
                            if(curR >= N || curR <= -1 || curC >= M || curC <= -1) break;

                            if(map[curR][curC] != 0 && count >= 2){
                                list.add(new Edge(before, map[curR][curC], count));
                                break;
                            }else if(map[curR][curC] != 0 && count < 2){
                                break;
                            }else{
                                count++;
                            }

                        }
                    }

                }
            }
        }
        
        
        
		Collections.sort(list);

		parent = new int[1001];

		for(int i=1; i<1001; i++){
			parent[i] = i;
		}

		int min = 0;		

        ArrayList<Integer>[] list2 = new ArrayList[1001];        
        boolean[] visit2 = new boolean[1001];
        for(int i=0; i<1001; i++) list2[i] = new ArrayList<>();
        int start = 0;

		for(int i=0; i<list.size(); i++){
			Edge cur = list.get(i);

			int from = find(cur.from);
			int to = find(cur.to);

			if(!sameParent(from, to)){
                list2[cur.from].add(cur.to);
                list2[cur.to].add(cur.from);
                start = cur.to;
				min += cur.weight;				
				union(cur.from, cur.to);
			}
		}

        boolean flag = false;

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(start);

        visit2[start] = true;
        int cnt2 = 1;

        while(!q2.isEmpty()){
            int cur = q2.poll();

            for(int k : list2[cur]){
                if(!visit2[k]){
                    visit2[k] = true;
                    cnt2++;
                    q2.add(k);                    
                }
            }
        }

        if(cnt2 == cnt){
            System.out.println(min == 0 ? -1 : min);
        }else{
            System.out.println(-1);
        }
		
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
	}
}

class Locate{
    int r,c;
    Locate(int r, int c){
        this.r =r;
        this.c = c;
    }
}