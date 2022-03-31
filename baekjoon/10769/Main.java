import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int cnt1= 0;
        int cnt2=0;
        
        for(int i=0; i<str.length()-2; i++){

            if(str.charAt(i) == ':'){
                if(str.charAt(i+1) == '-'){
                    if(str.charAt(i+2) == '('){
                        cnt1++;
                    }else if(str.charAt(i+2) == ')'){
                        cnt2++;
                    }
                }
            }
        }

        if(cnt1 == 0 && cnt2 == 0){
            System.out.println("none");
        }else if(cnt1 == cnt2){
            System.out.println("unsure");
        }else if(cnt1 > cnt2){
            System.out.println("sad");
        }else{
            System.out.println("happy");
        }

    }
}