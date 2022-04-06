import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        String a_str = String.valueOf(a);
        String b_str = String.valueOf(b);

        long min = 0;
        long max = 0;
        String min_str = "";
        String max_str = "";

        long a_min = 0;
        long a_max = 0;
        String a_min_str = "";
        String a_max_str = "";

        long b_min = 0;
        long b_max = 0;
        String b_min_str = "";
        String b_max_str = "";

        for(int i=0; i<a_str.length(); i++){
            if(a_str.charAt(i) == '5'){
                a_min_str = a_min_str + "5";
                a_max_str = a_max_str + "6";
            }else if(a_str.charAt(i) == '6'){
                a_min_str = a_min_str + "5";
                a_max_str = a_max_str + "6";
            }else{
                a_min_str = a_min_str + (a_str.charAt(i)+"");
                a_max_str = a_max_str + (a_str.charAt(i)+"");
            }
        }
        
        for(int i=0; i<b_str.length(); i++){
            if(b_str.charAt(i) == '5'){
                b_min_str = b_min_str + "5";
                b_max_str = b_max_str + "6";
            }else if(b_str.charAt(i) == '6'){
                b_min_str = b_min_str + "5";
                b_max_str = b_max_str + "6";
            }else{
                b_min_str = b_min_str + (b_str.charAt(i)+"");
                b_max_str = b_max_str + (b_str.charAt(i)+"");
            }
        }

        b_min = Long.parseLong(b_min_str);
        b_max = Long.parseLong(b_max_str);

        a_min = Long.parseLong(a_min_str);
        a_max = Long.parseLong(a_max_str);

        max = b_max + a_max;
        min = b_min + a_min;

        System.out.println(min + " " + max);
        

    }
}