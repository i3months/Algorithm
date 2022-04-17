import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Stack<Integer> st = new Stack<>();
        
        
        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(br.readLine());
            st.add(temp);
        }
           
        int compare = st.pop();
        int cnt = 1;
        int a = st.size();
        
        int max = compare;
        for(int i=0; i<a; i++){
            int temp = st.pop();

            if(temp > max){
                cnt++;
                max = temp;
            }
        }
        
        System.out.println(cnt);
    }
}
