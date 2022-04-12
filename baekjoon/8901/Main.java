import java.util.*;
import java.io.*;

 public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            int AB = Integer.parseInt(st.nextToken());
            int BC = Integer.parseInt(st.nextToken());
            int CA = Integer.parseInt(st.nextToken());

            int ans = 0;

            for(int j=0; j<=Math.min(A,B); j++){ // brute force searching
                for(int k=0; k<=Math.min(B-j,C); k++){
                    int temp = Math.min(A-j, C-k);
                    ans = Math.max(ans, AB*j+BC*k+CA*temp); 
                    // j == AB.num k == BC.num temp == CA.num .... 
                    // greedy would be good       
                }
            }

            sb.append(ans + "\n");
            
        } // end of for i

        System.out.println(sb);
    }


}