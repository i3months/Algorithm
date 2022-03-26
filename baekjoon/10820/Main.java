import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String input = "";

        while((input = br.readLine()) != null) {
            int so = 0;
            int dae = 0;
            int num = 0;
            int gong = 0;

            for(int i = 0; i<input.length(); i++){
                if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
                    so++;
                }
                if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
                    dae++;
                }
                if(input.charAt(i) - '0' >= 0 && input.charAt(i) - '0' <= 9){
                    num++;
                }
                if(input.charAt(i) == ' '){
                    gong++;
                }
            }
            System.out.println(so+" "+dae+" "+num+" "+gong);

        }

    }

    
}