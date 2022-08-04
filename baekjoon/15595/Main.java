import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int ans_num = 0;
        int before_ans = 0;

        ArrayList<String> wrong = new ArrayList<>();
        ArrayList<String> correct = new ArrayList<>();

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<N; i++){
            // StringTokenizer st = new StringTokenizer(br.readLine());
            String[] arr = br.readLine().split(" ");

            // int rate_num = arr[0];
            String rate_id = arr[1];
            int rate_result = Integer.parseInt(arr[2]);
            // int rate_memory = Integer.parseInt(st.nextToken());
            // int rate_time = Integer.parseInt(st.nextToken());
            // int rate_language = Integer.parseInt(st.nextToken());
            // int rate_length = Integer.parseInt(st.nextToken());

            if(rate_id.equals("megalusion")){
                continue;
            }
            
            if(rate_result == 4){
                // if(wrong.contains(rate_id)){
                //     wrong.remove(rate_id);
                // }

                if(correct.contains(rate_id)){
                    continue;
                }else{
                    correct.add(rate_id);
                    ans_num++;
                    before_ans += hm.getOrDefault(rate_id, 0);
                }
                
            }else{
                if(correct.contains(rate_id)){
                    continue;
                }

                // if(!wrong.contains(rate_id)){
                //     wrong.add(rate_id);
                // }
                
                hm.put(rate_id, hm.getOrDefault(rate_id, 0) + 1);
                // System.out.println(hm.get(rate_id));

                // if(hm.containsKey(rate_id)){
                //     hm.put(rate_id, hm.get(rate_id) + 1);
                // }else{
                //     hm.put(rate_id, 1);
                // }
                // System.out.println(hm.get(rate_id));
            }

            
        }

        if(ans_num + before_ans == 0){
            System.out.println(0);
        }else{
            double up = (double)ans_num;
            double down = ((double)(ans_num) + (double)(before_ans)) * 100.0;
            System.out.printf("%.10f",(up / down) * 10000);
        }

        // System.out.println(ans_num + " " + before_ans);
        
    }
}