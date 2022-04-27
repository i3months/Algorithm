import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);

        int cnt = 0;
        int ans = 0;

        for(int i = N; i>0; i--){            
            ans = ans + arr[cnt] * i;

            if(cnt == N-1){
                break;
            }
            
            cnt++;
            
        }

        System.out.println(ans);

        
    
    }
}