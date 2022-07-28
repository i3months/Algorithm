import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();      
        
        int N = Integer.parseInt(br.readLine());

        int[] arr1 = new int[N + 1];
        int[] arr2 = new int[N + 1];
        int[] arr3 = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<N + 1; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N+1; i++){
            arr3[i] = arr2[i] - arr1[i];
        }

        for(int i=1; i<N+1; i++){
            arr3[i] = arr3[i-1] + arr3[i];
        }

        int result = 0;
        int cnt = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=1; i<N+1; i++){
            if(arr3[i] == 0){
                result++;                
            }

            if(hm.containsKey(arr3[i] - 0)){
                cnt = hm.get(arr3[i] - 0);
            }else{
                cnt = 0;
            }
            
            result += cnt;
            
            if(hm.containsKey(arr3[i])){
                hm.put(arr3[i], hm.get(arr3[i]) + 1);
            }else{
                hm.put(arr3[i], 1);
            }
        }

        System.out.println(result);
        
    }
}