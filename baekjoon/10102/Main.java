import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int Acnt = 0;
        int Bcnt = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'A'){
                Acnt++;
            }else{
                Bcnt++;
            }
        }

        if(Acnt>Bcnt){
            System.out.println("A");
        }else if(Acnt < Bcnt){
            System.out.println('B');
        }else{
            System.out.println("Tie");
        }
       
    }
}