import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            int TTT = 0;
            int TTH = 0;
            int THT = 0;
            int THH = 0;
            int HTT = 0;
            int HTH = 0;
            int HHT = 0;
            int HHH = 0;

            for(int j=0; j<str.length()-2; j++){
                if(str.charAt(j) == 'T' && str.charAt(j+1) == 'T' && str.charAt(j+2) == 'T'){
                    TTT++;
                }
                if(str.charAt(j) == 'T' && str.charAt(j+1) == 'T' && str.charAt(j+2) == 'H'){
                    TTH++;
                }
                if(str.charAt(j) == 'T' && str.charAt(j+1) == 'H' && str.charAt(j+2) == 'T'){
                    THT++;
                }
                if(str.charAt(j) == 'T' && str.charAt(j+1) == 'H' && str.charAt(j+2) == 'H'){
                    THH++;
                }
                if(str.charAt(j) == 'H' && str.charAt(j+1) == 'T' && str.charAt(j+2) == 'T'){
                    HTT++;
                }
                if(str.charAt(j) == 'H' && str.charAt(j+1) == 'T' && str.charAt(j+2) == 'H'){
                    HTH++;
                }
                if(str.charAt(j) == 'H' && str.charAt(j+1) == 'H' && str.charAt(j+2) == 'T'){
                    HHT++;
                }
                if(str.charAt(j) == 'H' && str.charAt(j+1) == 'H' && str.charAt(j+2) == 'H'){
                    HHH++;
                }
            }

            sb.append(TTT + " " + TTH + " " + THT + " " + THH + " " + HTT + " " + HTH + " " + HHT + " " + HHH + " " +"\n");
        }

        System.out.println(sb);

    

    }
}