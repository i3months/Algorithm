import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeSet<Problem> ts = new TreeSet<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());

            hm.put(num, difficulty);
            ts.add(new Problem(num, difficulty));
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());
                ts.add(new Problem(num, difficulty));// 중복 검사 해야되지 않음?            
                hm.put(num, difficulty);    
            }else if(command.equals("recommend")){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    sb.append(ts.last().num + "\n");
                }else if(num == -1){
                    sb.append(ts.first().num + "\n");
                }
            }else if(command.equals("solved")){
                int num = Integer.parseInt(st.nextToken());
                int difficulty = hm.get(num);
                ts.remove(new Problem(num , difficulty));
            }
        }

        System.out.println(sb);

    }

    static class Problem implements Comparable<Problem> {
        int num = 0;
        int difficulty = 0;

        Problem(int a, int b) {
            num = a;
            difficulty = b;
        }

        public int compareTo(Problem o1) {
            if (difficulty > o1.difficulty) {
                return 1;
            } else if (difficulty < o1.difficulty) {
                return -1;
            } else {
                if(num > o1.num){
                    return 1;
                }else if(num < o1.num){
                    return -1;
                }else{
                    return 0;
                }
            }
        }

    } // end of class Problem

}
