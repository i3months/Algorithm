import java.io.*;
import java.util.*;
 
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        int N = Integer.parseInt(br.readLine());

        int[] arr1 = new int[N+1];
        int[] arr2 = new int[N+1];
        int[] arr3 = new int[N+1];
        int[] arr4 = new int[N+1];

        for(int i=1; i<N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());                            
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
            arr3[i] = Integer.parseInt(st.nextToken());
            arr4[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                int val = arr3[i] + arr4[j];

                hm.put(val, hm.getOrDefault(val, 0) + 1);                
            }
        }
        
        long ans = 0;

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                int val = arr1[i] + arr2[j];
                ans += hm.getOrDefault(-val, 0);
                // list2.add(-val);
            }
        }
        // Collections.sort(list2);

        System.out.println(ans);

        

        
    }
}