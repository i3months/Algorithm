import java.util.*;

import javax.xml.transform.stream.StreamSource;

import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0; i<N; i++){
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            int mid = (M+1) / 2;
            sb.append(mid + "\n");

            PriorityQueue<Integer> pq_min = new PriorityQueue<>();
            PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());

            int cnt = 0;

            for(int j=1; j<=M; j++){

                if(j % 10 == 1 && j != 1){
                    st = new StringTokenizer(br.readLine());
                }
                
                int tmp = Integer.parseInt(st.nextToken());

                if(pq_max.size() == pq_min.size()){
                    pq_max.add(tmp);
                }else{
                    pq_min.add(tmp);
                }

                if(!pq_min.isEmpty() && pq_max.peek() > pq_min.peek()){
                    int tmp2 = pq_max.poll();
                    int tmp3 = pq_min.poll();

                    pq_max.add(tmp3);
                    pq_min.add(tmp2);
                }

                if(j % 2 == 1){

                    if(cnt == 9 || j == M){
                        sb.append(pq_max.peek() + "\n");   
                        cnt = 0; 
                    }else{
                        sb.append(pq_max.peek() + " ");                    
                    }
                    
                    cnt++;
                }
                


            }
        }

        System.out.println(sb);

    }

}
