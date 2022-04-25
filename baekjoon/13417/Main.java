import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){            
            Deque<String> dq = new LinkedList<>();
            ArrayList<String> list = new ArrayList<>();

            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                list.add(st.nextToken());
            }

            dq.add(list.get(0));

            for(int j=1; j<list.size(); j++){
                if(dq.peekFirst().compareTo(list.get(j)) >= 0){
                    dq.addFirst(list.get(j));
                }else{
                    dq.addLast(list.get(j));
                }
            }

            while(!dq.isEmpty()){
                sb.append(dq.pollFirst());
            }
            sb.append("\n");
            
            
            
        }
        System.out.println(sb);
    }

}
