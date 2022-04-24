import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            String team = br.readLine();
            int num = Integer.parseInt(br.readLine());
            ArrayList<String> member = new ArrayList<>();
            for(int j=0; j<num; j++){
                String name = br.readLine();
                member.add(name);
            }
            Collections.sort(member);
            hm.put(team, member);
        }

        for(int i=0; i<M; i++){
            String name = br.readLine();
            int cmd = Integer.parseInt(br.readLine());

            if(cmd == 0){
                for(int j=0; j<hm.get(name).size(); j++){
                    sb.append(hm.get(name).get(j) + "\n");
                }
            }

            if(cmd == 1){
                for(String key : hm.keySet()){
                    if(hm.get(key).contains(name)){
                        sb.append(key + "\n");
                        break;
                    }
                }
            }


        }
        
        System.out.println(sb);

    }

}
