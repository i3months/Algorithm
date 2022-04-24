import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            StringTokenizer st3 = new StringTokenizer(br.readLine());

            String[] arr1 = new String[N];
            String[] arr2 = new String[N];

            for(int j=0; j<N; j++){
                arr1[j] = (st1.nextToken());    
            }

            for(int j=0; j<N; j++){
                arr2[j] = (st2.nextToken());    
            }

            HashMap<Integer, Integer> hm = new HashMap<>();

            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(arr2[j].equals(arr1[k])){
                        hm.put(j,k);
                        break;
                    }
                }
            }

            String[] ans = new String[N];

            for(int j=0; j<N; j++){
                int idx = hm.get(j);
                ans[idx] = st3.nextToken();
            }

            for(int j=0; j<N; j++){
                System.out.print(ans[j] + " ");
            }
            System.out.println();
            


        }


    

        
        
    }

}
