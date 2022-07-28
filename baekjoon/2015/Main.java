import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();      
        
        StringTokenizer st = new StringTokenizer(br.readLine()) ;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        long result = 0;
        long cnt = 0;

        for(int i=1; i<N+1; i++){
            if(arr[i] == K){
                result++;                
            }

            if(hm.containsKey(arr[i] - K)){
                cnt = hm.get(arr[i] - K);
            }else{
                cnt = 0;
            }
            
            result += cnt;
            
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }else{
                hm.put(arr[i], 1);
            }
        }

        System.out.println(result);

        
    }
}