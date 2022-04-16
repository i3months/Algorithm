import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String str2 =br.readLine();

        if(str.length() > str2.length()){
            System.out.println("go");
        }else{
            System.out.println("no");
        }
    }
}