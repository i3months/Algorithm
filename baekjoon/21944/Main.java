import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeSet<Problem> ts = new TreeSet<>();
        HashMap<Integer, Problem2> hm = new HashMap<>();

        ArrayList<TreeSet<Problem>> algorithm_list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0; i<101; i++){
            algorithm_list.add(new TreeSet<>()); 
        } // algorithm's kind == 100

        for(int i=0; i<N; i++){     
            st = new StringTokenizer(br.readLine());       
            int num = Integer.parseInt(st.nextToken());            
            int difficulty = Integer.parseInt(st.nextToken());    
            int algorithm = Integer.parseInt(st.nextToken());            
            
            ts.add(new Problem(num, difficulty));
            algorithm_list.get(algorithm).add(new Problem(num, difficulty));
            hm.put(num, new Problem2(difficulty, algorithm));
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("recommend")){
                int algorithm = Integer.parseInt(st.nextToken());
                int cmd = Integer.parseInt(st.nextToken());

                if(cmd == 1){
                    sb.append(algorithm_list.get(algorithm).last().num + "\n"); // first 일수도..
                }
                if(cmd == -1){
                    sb.append(algorithm_list.get(algorithm).first().num + "\n"); // last 일수도..
                }
            }

            if(command.equals("recommend2")){
                int cmd = Integer.parseInt(st.nextToken());

                if(cmd == 1){
                    sb.append(ts.last().num + "\n"); // swap..?
                }
                if(cmd == -1){
                    sb.append(ts.first().num + "\n"); // swap?
                }
            }

            if(command.equals("recommend3")){
                int cmd = Integer.parseInt(st.nextToken());
                int condition = Integer.parseInt(st.nextToken());

                if(cmd == 1){
                    Problem temp = ts.higher(new Problem(0, condition));
                    if(temp == null){
                        sb.append(-1 + "\n");
                    }else{
                        sb.append(temp.num + "\n");
                    }
                }

                if(cmd == -1){
                    Problem temp = ts.lower(new Problem(0, condition));
                    if(temp == null){
                        sb.append(-1 + "\n");
                    }else{
                        sb.append(temp.num + "\n");
                    }
                }
            }

            if(command.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());
                int algorithm = Integer.parseInt(st.nextToken());

                ts.add(new Problem(num, difficulty));
                algorithm_list.get(algorithm).add(new Problem(num, difficulty));
                hm.put(num, new Problem2(difficulty, algorithm));                
            }

            if(command.equals("solved")){
                int num = Integer.parseInt(st.nextToken());
                int difficulty = hm.get(num).difficulty;
                int algorithm = hm.get(num).algorithm;

                ts.remove(new Problem(num, difficulty));
                hm.remove(num);
                algorithm_list.get(algorithm).remove(new Problem(num, difficulty));
                
            }
        }

        System.out.println(sb);

        

    }

    static class Problem implements Comparable<Problem>{
        int num = 0;
        int difficulty = 0;

        Problem(int a, int b){
            num = a;
            difficulty = b;
        }

        public int compareTo(Problem o2){
            if(difficulty > o2.difficulty){
                return 1;                
            }else if(difficulty < o2.difficulty){
                return -1;
            }else{
                if(num > o2.num){
                    return 1;
                }else if(num < o2.num){
                    return -1;
                }else{
                    return 0;
                }
            }
        }

    }// end of Problem

    static class Problem2{
        int difficulty = 0;
        int algorithm = 0;

        Problem2(int a, int b){
            difficulty = a;
            algorithm = b;
        }
    }

}
