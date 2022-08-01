import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        String str = br.readLine();

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int[][] count = new int[27][str.length()];

        for(int i=0; i<27; i++){
            char tmp = (char)(i + 'a');            
            if(str.charAt(0) == tmp){
                count[tmp - 'a'][0]++;
            }
            for(int j=1; j<str.length(); j++){
                if(str.charAt(j) == tmp){
                    count[tmp - 'a'][j] = count[tmp - 'a'][j - 1]; 
                    count[tmp - 'a'][j]++;
                }else{
                    count[tmp - 'a'][j] = count[tmp - 'a'][j-1];
                }
            }    
        }

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char target = st.nextToken().charAt(0);

            int start = Integer.parseInt(st.nextToken());
            int fin = Integer.parseInt(st.nextToken());

            if(start == 0){
                sb.append(count[target - 'a'][fin] + "\n");    
            }else{
                sb.append(count[target - 'a'][fin] - count[target - 'a'][start-1] + "\n");
            }            
            
        }

        System.out.println(sb);

        // for(int i=0; i<str.length(); i++){
        //     System.out.print(str.charAt(i) + " ");
        // }
        // System.out.println();

        // for(int i=0; i<str.length(); i++){
        //     System.out.print(count['e' - 'a'][i] + " ");
        // }
        
    }
}