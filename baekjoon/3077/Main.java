import java.util.*;
import java.io.*;

public class Main {    
    static int N;
    static String[] arr;
    static boolean[] chk;
    static String list[];
    static int right = 0;
    static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        

        for(int i=0; i<N; i++){
            String str = st.nextToken();
            hm.put(str, i);
        }

        st = new StringTokenizer(br.readLine());

       

        arr = new String[N];
        chk = new boolean[N];
        list = new String[2];

        for(int i =0; i<N; i++){
            arr[i] = st.nextToken();
        }

        int total = (N * (N-1)) / 2;
        
        for(int i=0; i<N - 1; i++){
            for(int j = i + 1; j<N; j++){
                if(hm.get(arr[i]) < hm.get(arr[j])){
                    right++;
                }
            }
        }

        System.out.println(right + "/" + total);
        

    

        
        
    }

}
