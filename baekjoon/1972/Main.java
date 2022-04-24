import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("*")) {
                break;
            }

            surprise(str);
        }

        System.out.println(sb);

    }

    static void surprise(String str) {
        if(str.length() == 1){
            sb.append(str + " is surprising.\n");
            return;
        }

        boolean chk = false;

        for(int i=1; i<=str.length() - 2; i++){

            HashSet<String> hs = new HashSet<>();

            for(int j=0; j<str.length() - i; j++){
                String temp = String.valueOf(str.charAt(j)) + String.valueOf(str.charAt(j+i));                
                if(hs.contains(temp)){
                    chk = true;
                    break;
                }else{
                    hs.add(temp);
                }                                                
            }
            if(chk){
                break;
            }
        }

        if(chk){
            sb.append(str + " is NOT surprising.\n");
        }else{
            sb.append(str + " is surprising.\n");
        }
        
    }
}
