import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), "RC");
            
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(R == 0 && C == 0){
                break;
            }

            StringBuilder sb2 = new StringBuilder();

            while(C > 0){
                C--;
                sb2.append((char)('A' + (C % 26)) + "");
                C /= 26;
            }

            sb.append(sb2.reverse().toString() + R + '\n');
            
        }

        System.out.println(sb);
        
        
    }
}