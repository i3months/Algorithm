import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken())    ;
        }

        Arrays.sort(arr);
        
        System.out.println(arr[N-1-M]);

        
    }
    static class Node {
        long num, locate;
        Node(long num, long locate) {
            this.num = num;
            this.locate = locate;
        }
    }
}
