import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<pilar> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list.add(new pilar(x,h));
        }

        Collections.sort(list);              

        int target_x = list.get(0).x;
        int target_h = list.get(0).h;

        int ans = 0;

        int cand = 0;

        int max_idx = 0;        

        for(int i=1; i<list.size(); i++){
            if(list.get(i).h >= target_h){                
                ans = ans + (list.get(i).x - target_x) * target_h;
                target_x = list.get(i).x;
                target_h = list.get(i).h;
                max_idx = i;                                                              
            }
          
        } // end of for i

        target_x = list.get(list.size()-1).x;
        target_h = list.get(list.size()-1).h;

        pilar temp = new pilar(1,1);

        for(int i=list.size()-2; i>=max_idx; i--){
            if(target_h <= list.get(i).h){
                ans = ans + (target_x - list.get(i).x) * target_h;
                target_x = list.get(i).x;
                target_h = list.get(i).h;
                temp = list.get(i);
            }
        }
        
        ans = ans + list.get(max_idx).h;

        System.out.println(ans);                    
 
    }

    static class pilar implements Comparable<pilar>{
        int x;
        int h;

        pilar(int a, int b){
            x = a;
            h = b;
        }


        public int compareTo(pilar o2){
            if(x > o2.x){
                return 1;
            }else if(x < o2.x){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
