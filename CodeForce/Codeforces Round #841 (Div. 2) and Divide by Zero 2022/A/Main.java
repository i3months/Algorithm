import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            int N = Integer.parseInt(br.readLine());

            long[] arr = new long[N+1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++) arr[i] = Long.parseLong(st.nextToken());

            while(true) {
                long firstValue = -1;
                int first = -1;
                for(int i=1; i<N+1; i++) {
                    if(arr[i] != 1) {
                        firstValue = arr[i];
                        first = i;
                        break;
                    }
                }

                long secondValue = -1;
                int second = -1;
                for(int i=1; i<N+1; i++) {
                    if(arr[i] != 1 && i != first) {
                        secondValue = arr[i];
                        second = i;
                        break;
                    }
                }

                if(first == -1 || second == -1) break;

                long val = firstValue * secondValue;
                arr[first] = val;
                arr[second] = 1;
            }

            long sum = 0;
            for(int i=1; i<N+1; i++) {
                sum += arr[i];
            }
            sum *= 2022;

            sb.append(sum + "\n");
            
        }

        System.out.println(sb);


    }   
}
