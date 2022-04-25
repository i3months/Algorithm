import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<String>[] st_arr = new Stack[N];

        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            st_arr[i] = new Stack<>();
            while(st.hasMoreTokens()){
                String tmp = st.nextToken();
                st_arr[i].push(tmp);
            }    
        }

        String[] receive = br.readLine().split(" ");    

        for(int i=receive.length - 1; i >= 0; i--){
            for(int j=0; j<N; j++){
                if(!st_arr[j].isEmpty()){
                    if(st_arr[j].peek().equals(receive[i])){
                        st_arr[j].pop();
                        break;
                    }    
                }

                
            }
        }

        boolean chk = false;

        for(int i=0; i<N; i++){
            if(!st_arr[i].isEmpty()){
                chk = true;        
                break;
            }
        }


        if(chk){
            System.out.println("Impossible");
        }else{
            System.out.println("Possible");
        }

        

    }
}
