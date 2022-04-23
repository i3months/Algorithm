import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> in = new HashMap<>();
        HashMap<String, Integer> out = new HashMap<>();

        
        for(int i=0; i<N; i++){
            String car = br.readLine();
            in.put(car, i);            
        }

        for(int i=0; i<N; i++){
            String car = br.readLine();
            out.put(car, i);            
        }

        LinkedList<String> in_car = new LinkedList<>(in.keySet());
        LinkedList<String> out_car = new LinkedList<>(out.keySet());

        Collections.sort(in_car, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(in.get(o1) > in.get(o2)){
                    return 1;
                }else if(in.get(o1) < in.get(o2)){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        Collections.sort(out_car, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(out.get(o1) > out.get(o2)){
                    return 1;
                }else if(out.get(o1) < out.get(o2)){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        int cnt = 0;

        while(true){

            if(in_car.isEmpty() || out_car.isEmpty()){
                break;
            }

            if(out_car.peekFirst().equals(in_car.peekFirst())){
                String tmp = out_car.pollFirst();
                in_car.remove(tmp);
            }else{
                cnt++;                
  
                String tmp = out_car.pollFirst();
                in_car.remove(tmp);
            }

            
        }

        System.out.println(cnt);

    }
}
