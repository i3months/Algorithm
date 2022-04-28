import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        double W = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());

        double lng = Math.sqrt(Math.pow(W,2)+Math.pow(H,2));

        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());

            int b = (int)lng;    
            
            if(a <= b){
                System.out.println("DA");
            }else{
                System.out.println("NE");
            }
        }


    }
}