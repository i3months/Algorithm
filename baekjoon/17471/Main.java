import java.io.*;
import java.util.*;
 
public class Main {

    static int INF = 987654321;
    static int N;
    static ArrayList<Integer>[] list;
    static int population[];
    static int total;
    static boolean select[];
    static ArrayList<Integer> tmp_list = new ArrayList<>();

    static int ans = 987654321;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        N = Integer.parseInt(br.readLine());
        
        select = new boolean[N + 1];
        population = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            population[i] = Integer.parseInt(st.nextToken());
            total += population[i];
        }

        list = new ArrayList[N + 1];

        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            for(int j=0; j<num; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }            
        } 
        
        PickNumber(1,0);

        System.out.println(ans == INF ? -1 : ans);
    
    }

    static void Calculate(){
        int a_sum = 0;
        int b_sum = 0;
        
        for(int i=1; i<N+1; i++){
            if(select[i]) a_sum += population[i];
            else b_sum += population[i];                        
        }

        int diff = Math.abs(b_sum - a_sum);

        ans = Math.min(ans , diff);

    }

    static void PickNumber(int idx, int cnt){
        if(cnt >= 1){
            
            if(CheckFirst()){
                Calculate();
            }

        }

        for(int i=idx; i<N+1; i++){
            if(select[i]) continue;
            select[i] = true;
            PickNumber(i, cnt + 1);
            select[i] = false;     
        }
        
    }

    static boolean CheckFirst(){
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        for(int i=1; i<N+1; i++){
            if(select[i]) A.add(i);
            else B.add(i);    
        }

        if(A.size() == 0 || B.size() == 0) return false;
        
        boolean check_a = CheckConnection(A, true);
        boolean check_b = CheckConnection(B, false);

        return check_a && check_b;

    }

    static boolean CheckConnection(ArrayList<Integer> c, boolean area){
        boolean visit[] = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(c.get(0));
        visit[c.get(0)] = true;
        
        int cnt = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int k : list[cur]){
                if(select[k] != area) continue;
                if(visit[k]) continue;

                cnt++;
                visit[k] = true;
                q.add(k);
            }
        }

        if(c.size() == cnt) return true;
        else return false;

    }


}