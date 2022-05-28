import java.util.*;
import java.io.*;

public class Main {

    static int N;        
    static int M;

    static int target1;
    static int target2;

    static int[] parent;
    static ArrayList<Integer>[] list;
    static boolean[] visit;   

    static int[] dist;
    
    static StringBuilder sb = new StringBuilder();
        

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];

        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
                
        visit = new boolean[N+1];      
        
        ArrayList<Integer> list1 = new ArrayList<>();

        for(int y : list[1]){
            list1.add(y);
            visit[y] = true;
        }

        for(int i=0; i<list1.size(); i++){
            for(int y : list[list1.get(i)]){
                visit[y] = true;
            }
        }

        int cnt = 0;
        for(int i=2; i<N+1; i++){
            if(visit[i]){
                cnt++;
            }
        }
        System.out.println(cnt);



      


        
    }
}