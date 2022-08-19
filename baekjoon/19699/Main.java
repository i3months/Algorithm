import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int[] select;
    static int[] arr;
    static boolean[] prime = new boolean[900000];
    static int N, M;
    static boolean[] visit;

    static ArrayList<Integer> list = new ArrayList<>();
    static HashSet<Integer> list2 = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        prime[0] = prime[1] = true;

        for(int i = 2; i*i < 90000; i++){
            if(!prime[i]){
                for(int j=i * i; j<90000; j+=i){
                    prime[j] = true;
                }
            }
        }
    
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int[M];
        arr = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

            
        bt(0,0);

        list = new ArrayList<>(list2);
        Collections.sort(list);

        if(list.isEmpty()){
            System.out.println(-1);
            return;
        }
        for(int k : list){
            System.out.print(k + " ");
        }

    }
    
    static void bt(int depth, int idx){
        if(depth == M){
            // calculate    
            int sum = 0;

            for(int i=0; i<M; i++){
                sum += select[i];
            }

            if(!prime[sum]){
                list2.add(sum);
            }

            return;
            
        }


        for(int i=idx; i<N; i++){            
            if(!visit[i]){
                visit[i] = true;
                select[depth] = arr[i];
                bt(depth + 1, i + 1);  
                visit[i] = false; 
            }            
            
        }

        

    }
}