import java.util.*;
import java.io.*;

public class Main {    

    static int[] month_arr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");

        int N = Integer.parseInt(tmp[0]);
        int F = Integer.parseInt(tmp[2]);
        
        String[] tmp2 = tmp[1].split("/"); // split 이거 안될수도.. 
        String[] tmp3 = tmp2[1].split(":");

        int L = Integer.parseInt(tmp2[0]) * 24 * 60 + Integer.parseInt(tmp3[0]) * 60 + Integer.parseInt(tmp3[1]);

        HashMap<String, HashMap<String, Long>> hm = new HashMap<>();
        HashMap<String, Long> penalty_user = new HashMap<>();        
        
        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split(" ");
         
            String[] arr1 = arr[1].split(":");

            int min = Integer.parseInt(arr1[1]);
            int hour = Integer.parseInt(arr1[0]);

            String[] arr2 = arr[0].split("-"); // 이거 안될수도..?
            
            int month_save = Integer.parseInt(arr2[1]);
            int month = 0;

            for(int j=1; j<month_save; j++){
                month = month + month_arr[j];
            }

            int day = Integer.parseInt(arr2[2]);

            long time = min + hour * 60 + day * 24 * 60 + month * 24 * 60;
            String name = arr[3];
            String parts = arr[2];
                                       
            if(hm.containsKey(name)){
                if(!hm.get(name).containsKey(parts)){
                    hm.get(name).put(parts, time);
                }else{
                    long borrow_time = hm.get(name).get(parts);
                    long return_time = time;
                    long penalty_time = return_time - borrow_time;
                    

                    if(!penalty_user.containsKey(name)){
                        if(penalty_time > L){
                            penalty_user.put(name, (penalty_time - L) * F);
                        }

                    }else{
                        long cumulative = penalty_user.get(name) + (penalty_time - L) * F;
                        penalty_user.put(name, cumulative);
                    }
                    hm.get(name).remove(parts);
                }
            }else{
                hm.put(name, new HashMap<>());
                hm.get(name).put(parts, time);            
            }

            


        } // end of for i

        ArrayList<String> list = new ArrayList<>(penalty_user.keySet());
        Collections.sort(list);

        if(list.isEmpty()){
            System.out.println(-1);
        }else{
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i) + " " + penalty_user.get(list.get(i)));
            }
        }

        

        

        
    }

    static class borrow{
        long time = 0; // int로 되겠지..? 안되면 수정하자.
        String name = "";

        borrow(long a, String b){
            time = a;
            name = b;
        }
    }

    static class user implements Comparable<user>{
        String name;
        long penalty;

        user(String a, long b){
            name = a;
            penalty = b;
        }

        public int compareTo(user o2){
            return name.compareTo(o2.name);
        }
    }

}
