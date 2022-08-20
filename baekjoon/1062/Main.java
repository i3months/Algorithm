import java.util.*;
import java.io.*;
import java.math.*;
// dasf
public class Main {
    static int N, K;
    static int max = -1;
    static boolean[] visit;
    static String[] arr;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new String[N];

        for(int i=0; i<N; i++){
            arr[i] = br.readLine().replace("anta", "").replace("tica", "");
        }

        if(K < 5){
            System.out.println(0);
            return;
        }

        if(K == 26){
            System.out.println(N);
        }

        visit = new boolean[26];

        visit['a' - 'a'] = true;
        visit['c' - 'a'] = true;
        visit['i' - 'a'] = true;
        visit['n' - 'a'] = true;
        visit['t' - 'a'] = true;

        bt(0,0);
        System.out.println(max);
        

    }

    static void bt(int a, int len){
        if(len == K - 5){
            int cnt = 0;
            for(int i=0; i<N; i++){
                boolean chk = true;
                for(int j=0; j<arr[i].length(); j++){
                    if(!visit[arr[i].charAt(j) - 'a']){
                        chk = false;
                        break;
                    }
                }
                if(chk){
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
            return;
        }

        for(int i=a; i<26; i++){
            if(!visit[i]){
                visit[i] = true;
                bt(i, len + 1);
                visit[i] = false;
            }
        }
        
    }
}