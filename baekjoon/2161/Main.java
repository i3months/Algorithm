import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> q = new LinkedList<>();
        
        for(int i=1; i<N+1; i++){
            q.add(i);
        }
        
        while(true){
            if(q.isEmpty()){
                break;
            }
            
            System.out.print(q.pollFirst() + " ");

            if(q.isEmpty()){
              break;
            }
            int temp = q.pollFirst();
            q.addLast(temp);

        }
    }
}