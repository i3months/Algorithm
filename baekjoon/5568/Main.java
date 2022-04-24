import java.util.*;
import java.io.*;    
public class Main {
    // dfs공부
    static int N = 0;
    static int K = 0;
    static HashSet<Integer> hs = new HashSet<>();
    static boolean chk[];
    static int[] card;
    static int[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N =  Integer.parseInt(br.readLine());
        K =  Integer.parseInt(br.readLine());

        card = new int[N];
        list = new int[K];
        chk = new boolean[N];

        for(int i=0; i<N; i++){
            card[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);

        System.out.println(hs.size());

        

        

    }

    static void dfs(int d){
        if(d == K){
            String complete = "";
            for(int i=0; i<list.length; i++){
                complete = complete + list[i] + "";
            }
            hs.add(Integer.parseInt(complete));
            return;
        }

        for(int i=0; i<N; i++){
            if(!chk[i]){
                chk[i] = true;
                list[d] = card[i];
                dfs(d+1);
                chk[i] = false;
            }
        }
    }   
}
