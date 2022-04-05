import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String ans = "";

        for(int i=0; i<str.length(); i++){

            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                String temp = (str.charAt(i)+"").toUpperCase();
                ans = ans + temp;
            }else{
                String temp = (str.charAt(i)+"").toLowerCase();
                ans = ans + temp;
            }

            
        }

        System.out.println(ans);

	}

}