import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String before = br.readLine();
        String after = br.readLine();

        if(N % 2 == 0){
            if(before.equals(after)){
                System.out.println("Deletion succeeded");
            }else{
                System.out.println("Deletion failed");
            }
        }else{
            String temp = before.replace('0', '2');
            temp = temp.replace('1', '3');
            temp = temp.replace('2', '1');
            temp = temp.replace('3', '0');
            if(temp.equals(after)){
                System.out.println("Deletion succeeded");
            }else{
                System.out.println("Deletion failed");
            }
        }
        
       
    }
}