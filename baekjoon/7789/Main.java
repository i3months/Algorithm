import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String str_N = st.nextToken();
        String str_M = st.nextToken();

        int check_1 = Integer.parseInt(str_M + str_N);
        int check_2 = Integer.parseInt(str_N);

        boolean a = true;
        boolean b = true;

        for(int i=2; i<Math.sqrt(check_1); i++){
            if(check_1 % i == 0){
                a = false;
            }
        }

        for(int i=2; i<Math.sqrt(check_2); i++){
            if(check_2 % i == 0){
                b = false;
            }
        }

        
        if(a && b){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        
        

        
    }

    
}