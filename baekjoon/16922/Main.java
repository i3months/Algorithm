import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static boolean[] arr = new boolean[200000000];
    static boolean visit[];

    static StringBuilder sb = new StringBuilder();

    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        N = Integer.parseInt(br.readLine());
        hm.put(0, 1);
        hm.put(1, 5);
        hm.put(2,10);
        hm.put(3,50);

        visit = new boolean[N];

        bt(0,0,0);

        System.out.println(ans);

    }

    static void bt(int depth, int num, int idx){
        if(depth == N){
            if(!arr[num]){
                arr[num] = true;
                ans++;
            }

            return; 
        }

        for(int i=idx; i<4; i++){
            if(!visit[depth]){
                visit[depth] = true;
                int nextNum = num + hm.get(i);
                bt(depth + 1, nextNum,i);
                visit[depth] = false;
            }
        }

        

    }
}