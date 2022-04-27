import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int s11 = s1.length();
        int s22 = s2.length();


        int max = 0;
        int min = 0;

        boolean chk = false;

        if(s11 >= s22){
            max = s11;
            min = s22;
            chk = true;            
        }else{
            max = s22;
            min = s11;
            chk = false;
        }

      

        for(int i=0; i<max-min; i++){
            if(!chk){
                q1.add(0);
            }else{
                q2.add(0);
            }
            
        }

        for(int i=0; i<s11; i++){
            q1.add(s1.charAt(i) - '0');
        }

        for(int j=0; j<s22; j++){
            q2.add(s2.charAt(j) - '0');
        }

        while(true){
            if(q1.isEmpty() || q2.isEmpty()){
                break;
            }

            System.out.print(q1.poll() + q2.poll());
        }
    
    }
}