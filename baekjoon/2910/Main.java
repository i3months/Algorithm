import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, member> hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(st.nextToken());
            
            if(hm.containsKey(temp)){
                int tmp = hm.get(temp).sequence;
                hm.put(temp, new member(hm.get(temp).count + 1, tmp));
            }else{
                hm.put(temp, new member(1, i));
            }
        }

        ArrayList<Integer> list = new ArrayList<>(hm.keySet());

        Collections.sort(list, new Comparator<Integer>(){
            @Override                        
            public int compare(Integer o1, Integer o2){
                if(hm.get(o1).count > hm.get(o2).count){
                    return -1;  // 빈도수 내림차순으로
                }else if(hm.get(o1).count < hm.get(o2).count){
                    return 1;
                }else{
                    if(hm.get(o1).sequence > hm.get(o2).sequence){ // 빈도수가 같으면 들어온 순서로 판단
                        return 1; // 들어온 순서는 오름차순
                    }else if(hm.get(o1).sequence < hm.get(o2).sequence){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        });

        for(int i : list){
            for(int j=0; j<hm.get(i).count; j++){
                System.out.print(i + " ");
            }
        }

        


    }
}

class member{
    int count;
    int sequence;


    member(int a, int b){
        count = a;
        sequence = b;
    }
}