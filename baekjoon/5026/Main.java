import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i< N; i++){
            String str = br.readLine();
            if(str.equals("P=NP")){
                System.out.println("skipped");
            }else{
                StringTokenizer st = new StringTokenizer(str, "+");
                int a = Integer.parseInt(st.nextToken());
                int b= Integer.parseInt(st.nextToken());
                
                System.out.println(a+b);
            }
        }
    }
}