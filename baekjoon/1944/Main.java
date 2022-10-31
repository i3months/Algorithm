import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M;
    static ArrayList<Edge> list = new ArrayList<>();
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());        

        char[][] map = new char[N + 1][N + 1];

        int startR = 0;
        int startC = 0;

        int num = 1;

        ArrayList<Locate> key_list = new ArrayList<>();

        for(int i=1; i<N+1; i++){
            String str = br.readLine();
            for(int j=1; j<N+1; j++){
                map[i][j] = str.charAt(j - 1);
                if(map[i][j] == 'S'){
                    startR = i;
                    startC = j;
                }
                if(map[i][j] == 'K'){
                    num++;
                    key_list.add(new Locate(i, j, num));
                }
                
            }
        }

        int[][] visit = new int[N + 1][N + 1];

        Queue<Locate> q = new LinkedList<>();
        q.add(new Locate(startR, startC));

        visit[startR][startC] = 1;

        while(!q.isEmpty()){
            Locate cur = q.poll();

            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR >= N + 1 || nextR <= 0 || nextC >= N + 1 || nextC <= 0) continue;
                if(visit[nextR][nextC] != 0) continue;
                if(map[nextR][nextC] == '1') continue;
                
                visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
                q.add(new Locate(nextR, nextC));
            }
        }

        // System.out.println("debug");
        
        for(Locate k : key_list){
            if(visit[k.r][k.c] != 0){
                list.add(new Edge(1, k.num, visit[k.r][k.c] - 1));
                // System.out.println(visit[k.r][k.c] - 1);
            }
        }

        // System.out.println("debug");

        for(Locate k : key_list){
            startR = k.r;
            startC = k.c;

            visit = new int[N + 1][N + 1];

            q = new LinkedList<>();
            q.add(new Locate(startR, startC));
    
            visit[startR][startC] = 1;
    
            while(!q.isEmpty()){
                Locate cur = q.poll();
    
                for(int i=0; i<4; i++){
                    int nextR = cur.r + dr[i];
                    int nextC = cur.c + dc[i];
    
                    if(nextR >= N + 1 || nextR <= 0 || nextC >= N + 1 || nextC <= 0) continue;
                    if(visit[nextR][nextC] != 0) continue;
                    if(map[nextR][nextC] == '1') continue;
                    
                    visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
                    q.add(new Locate(nextR, nextC));
                }
            }
            
            for(Locate l : key_list){
                if(visit[l.r][l.c] != 0 && visit[l.r][l.c] != 1){
                    list.add(new Edge(k.num, l.num, visit[l.r][l.c] - 1));
                    // System.out.println("debug"  + (visit[l.r][l.c] - 1));
                }
            }            
        }

        

        Collections.sort(list);        

        ArrayList<Integer>[] check_list = new ArrayList[num + 1];
        for(int i=0; i<num+1; i++) check_list[i] = new ArrayList<>();

        parent = new int[num + 1];
        for(int i=0; i<num+1; i++){
            parent[i] = i;
        }

        int ans = 0;

        for(int i=0; i<list.size(); i++){
            Edge cur = list.get(i);

            int start = find(cur.start);
            int end = find(cur.end);

            if(!sameParent(start, end)){
                ans += cur.weight;
                // System.out.println(cur.weight);
                union(cur.start, cur.end);
                check_list[start].add(end);
                check_list[end].add(start);
                // System.out.println(start + " " + end);
            }                    
        }

        boolean[] visit2 = new boolean[num + 1];
        Queue<Integer> q2 = new LinkedList<>();
        visit2[1] = true;
        q2.add(1);

        while(!q2.isEmpty()){
            int cur = q2.poll();

            for(int k : check_list[cur]){
                if(visit2[k]) continue;
                visit2[k] = true;
                q2.add(k);
            }
        }
        
        boolean flag = false;

        for(int i=1; i<num+1; i++){
            if(!visit2[i]){
                flag = true;
            }
        }

        // for(boolean k : visit2){
        //     System.out.println(k);
        // }

        if(flag){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
        // System.out.println(ans == 0 ? -1 : ans);

            
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

    public int compareTo(Edge o2){
        if(weight > o2.weight){
            return 1;
        }else if(weight == o2.weight){
            return 0;
        }else{
            return -1;
        }
        // return weight > o2.weight ? 1 : -1;
    }
}

class Locate{
    int r, c, num;
    Locate(int r, int c, int num){this.r=r;this.c=c; this.num=num;}
    Locate(int r, int c){this.r=r;this.c=c;}
}