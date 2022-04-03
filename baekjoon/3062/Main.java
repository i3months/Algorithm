import java.util.*;
import java.io.*;

public class Main {
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            int temp = Integer.parseInt(str);
            String temp2 = "";
            for(int j = str.length()-1; j>=0; j--){
                temp2 = temp2 + str.charAt(j);
            }
            int temp3 = Integer.parseInt(temp2);

            int sum = temp + temp3;
            String sum_str = String.valueOf(sum);

            boolean check = false;

            for(int k=0, l= sum_str.length()-1; k<sum_str.length() / 2; k++, l--){
                if(sum_str.length() % 2 == 0){
                    if(k == sum_str.length()-1){
                        break;
                    }    
                }else if(sum_str.length() % 2 == 1){
                    if(k == sum_str.length()){
                        break;
                    }
                }
                

                if(sum_str.charAt(k) == sum_str.charAt(l)){
                    check = true;
                }else{
                    check = false;
                    break;
                }
            }

            if(check){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }


        System.out.println(sb);
            
    }

}

