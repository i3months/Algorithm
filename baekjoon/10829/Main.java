import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long N  = Long.parseLong(br.readLine());

        String str = Long.toBinaryString(N);
        System.out.println(str);
   }
}