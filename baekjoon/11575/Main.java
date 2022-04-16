import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            String str = br.readLine();
            
            for(int j=0; j<str.length(); j++){
                int temp = str.charAt(j) - 'A';
                int ans = (a * temp + b) % 26;
                sb.append((char)(ans+'A'));
                
            }
            sb.append("\n");
        }
        System.out.print(sb);
        
    }
}