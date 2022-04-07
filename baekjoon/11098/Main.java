import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int M = Integer.parseInt(br.readLine());
            HashMap<Integer, String> hm = new HashMap<>();

            for(int j =0; j<M; j++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int temp = Integer.parseInt(st.nextToken());
                String temp2 = st.nextToken();

                hm.put(temp,temp2);
                
            }

            Object[] arr = hm.keySet().toArray();
            Arrays.sort(arr);

            System.out.println(hm.get(arr[arr.length-1]));

        }
    }

}