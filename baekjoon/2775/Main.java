import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<N; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(solu(k,n)).append("\n");
            
        }

        System.out.println(sb);

    

    }

    static public int solu(int k, int n){
        int count = 0;

        if(k == 0){
            return n;
        }

        for(int i=1; i<n+1; i++){
            count = count + solu(k-1,i);
        }
        
        return count;



    }
}