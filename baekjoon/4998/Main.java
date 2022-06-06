import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            double N = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());
            double M = Double.parseDouble(st.nextToken());
            int cnt = 0;
            double v = N;

            while(true){
                cnt++;
                double plus = N * B / 100.0;
                v = v + plus;
                N = N + plus;
                if(v >= M){
                    break;
                }
            }
            System.out.println(cnt);
            
        }

        
    }
}