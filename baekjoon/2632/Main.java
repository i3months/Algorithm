import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        
        for(int i=0; i<N; i++) arr1[i] = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) arr2[i] = Integer.parseInt(br.readLine());

        int max1 = 0;
        int max2 = 0;

        for(int k : arr1) max1 += k;
        for(int k : arr2) max2 += k;

        int[] count1 = new int[Math.max(max1, K)+1];
        int[] count2 = new int[Math.max(max2, K)+1];

        count1[0] = 1;
        count1[max1] = 1;
        count2[0] = 1;
        count2[max2] = 1;

        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=1; j<N; j++) {
                int idx = (i+j) % N;
                if(sum + arr1[idx] > K) break;
                sum += arr1[idx];
                count1[sum]++;
            }
        }

        for(int i=0; i<M; i++) {
            int sum = 0;
            for(int j=1; j<M; j++) {
                int idx = (i+j) % M;
                if(sum + arr2[idx] > K) break;
                sum += arr2[idx];
                count2[sum]++;
            }
        }

        int ans = 0;
        for(int i=0; i<K+1; i++) {
            ans += (count1[i] * count2[K-i]);
        }
        System.out.println(ans);


        
    }

}