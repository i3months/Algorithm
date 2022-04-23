import java.util.*;
import java.io.*;
public class Main041{

    static Long P;
    static Long Q;
    static Long N;
    static HashMap<Long, Long> hm;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        hm = new HashMap<>();

        long ans = solve(N);

        System.out.println(ans);


        
    }
    static long solve(long i){

        if(i == 0){
            return 1;
        }

        if(hm.containsKey(i)){
            return hm.get(i);
        }

        hm.put(i, solve(i / P) + solve(i / Q));

        return hm.get(i);
    }
}
