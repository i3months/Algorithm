import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String a1 = br.readLine();
            String a2 = br.readLine();


            int cnt = 0;

            for(int j=0; j<a1.length(); j++){
                if(a1.charAt(j)!=a2.charAt(j)){
                    cnt++;
                }
            }

            System.out.printf("Hamming distance is %d.\n", cnt);
        }


    }
}