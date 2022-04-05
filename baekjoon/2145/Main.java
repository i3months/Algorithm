import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int a = Integer.parseInt(br.readLine());

            if(a == 0){
                break;
            }

            while(true){
                String str = String.valueOf(a);
                int temp = 0;

                for(int i=0; i<str.length(); i++){
                    temp = temp + str.charAt(i) - '0';                    
                }                                

                a = temp;       
                     
                if(temp < 10){
                    break;
                }    
            }

            System.out.println(a);
        }
	}

}