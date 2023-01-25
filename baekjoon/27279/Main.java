import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m+1];
        int[] sumArr = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(st.nextToken());            
            sumArr[a]++;            
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<m+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=m-1; i>=1; i--) {
            sumArr[i] += sumArr[i+1]; arr[i] += arr[i+1];
        }

        //
        // for(int i=1; i<m+1; i++) {
        //     System.out.print(sumArr[i] + " ");
        // }
        // System.out.println();
        // for(int i=1; i<m+1; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
        //
        
        for(int i=1; i<m+1; i++) {
            if(sumArr[i] < arr[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
