import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == b && b == c){
                arr[i] = 10000 + a * 1000;
            }else if(a == b && b != c){
                arr[i] = 1000 + a * 100;
            }else if(a == c && c != b){
                arr[i] = 1000 + a * 100;
            }else if(b == c && c != a){
                arr[i] = 1000 + a * 100;
            }else{
                int max = Math.max(a,b);
                max = Math.max(max,c);
                arr[i] = 100 * max;
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[N-1]);
    }
}

