import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        

        N = Integer.parseInt(br.readLine());

        bt("");
                        
        
    }

    static void bt(String res){
        if(res.length() == N){
            System.out.println(res);
            System.exit(0);
        }

        for(int i=1; i<4; i++){
            if(isGood(res + String.valueOf(i))){
                bt(res+String.valueOf(i));
            }
        }        

    }

    static boolean isGood(String str){
        int len = str.length() / 2;

        for(int i=1; i<len + 1; i++){
            if(str.substring(str.length() - i).equals(str.substring(str.length() - 2 * i, str.length() - i))){
                return false;
            }
        }

        return true;
    }
    
}