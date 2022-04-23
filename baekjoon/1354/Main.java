import java.util.*;
import java.io.*;
public class Main{
// 무한수열. 해시맵을 사용한 dp. 재귀에 대한 이해.

    static long N;
    static long P;
    static long Q;
    static long X;
    static long Y;
    
    static HashMap<Long, Long> hm;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());        
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        hm = new HashMap<>();

        long ans = solve(N);

        System.out.println(ans);


        
    }

    static long solve(long i){

        if(i <= 0){
            return 1;
        }

        if(hm.containsKey(i)){
            return hm.get(i);
        }

        hm.put(i, solve((i / P) - X) + solve((i / Q) - Y));

        return hm.get(i);
    }
}
