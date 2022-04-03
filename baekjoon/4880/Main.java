import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int a3 = Integer.parseInt(st.nextToken());

            if(a1 == a2 && a2 == a3 && a3 == 0){
                break;
            }

            if(a3 - a2 == a2 - a1){
                System.out.printf("AP %d\n", a3 + a3 - a2);
            }else

            if(a3 / a2 == a2 / a1){
                System.out.printf("GP %d\n", a3 * (a3 / a2));
            }
        }
        
    }

}

