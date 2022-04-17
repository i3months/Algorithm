import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<String> q = new LinkedList<>();

        for(int i=0; i<N; i++){
          String str = br.readLine();

          q.add(str);
        }


        ArrayList<String> student;

        long cnt = 0;

        while(true){

          if(q.isEmpty()){
            break;
          }

          String candidate = q.pollFirst();
          student = new ArrayList<>();

          if(K > q.size()){
            K = q.size();
          }

          for(int i=0; i<K; i++){
            
            String temp = q.pollFirst();

            if(temp.length() == candidate.length()){
              cnt++;
              
            }

            student.add(temp);
          }

          for(int i=student.size()-1; i>=0; i--){
            q.addFirst(student.remove(i));
          }
          
          
        }// end of while 

        System.out.println(cnt);
    
        
   
    }
}
