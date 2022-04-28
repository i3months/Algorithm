import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
            String str = br.readLine();

            int mid1 = str.length() / 2;
            int mid2 = (str.length() / 2) - 1;

            if(str.charAt(mid1) == str.charAt(mid2)){
                System.out.println("Do-it");
            }else{
                System.out.println("Do-it-Not");
            }
        }



    }
}