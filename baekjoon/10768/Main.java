import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if(a == 2 && b == 18){
            System.out.print("Special");
        }else if(a == 2 && b < 18){
            System.out.print("Before");
        }else if(a == 2 && b > 18){
            System.out.print("After");
        }else if(a == 1){
            System.out.println("Before");
        }else{
            System.out.println("After");
        }
    }
}