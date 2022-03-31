import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());
        
        int[] tap = new int[K];
        st = new StringTokenizer(br.readLine());

        int sum = 0;

        for(int i=0; i<K; i++){
            int temp = 0;
            int temp2 = Integer.parseInt(st.nextToken());

            if(temp2 % 2 == 0){
                temp = temp2 / 2;
            }else{
                temp = (temp2 / 2) + 1;
            }

            
            sum = sum + temp;    
        }

        if(sum >= N){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        

    }
}