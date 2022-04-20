import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 1

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()); // toot .....
            LinkedList<String> list = new LinkedList<>();

            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            // debug!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


            while(true){
                String str = br.readLine();

                if(str.equals("what does the fox say?")){
                    break;
                }

                String[] arr = str.split(" ");

                while(true){

                    if(list.contains(arr[2])){
                        list.remove(arr[2]);
                    }else{
                        break;
                    }
                               
                }

       



            }

            for(int j=0; j<list.size(); j++){
                sb.append(list.get(j) + " ");
            }
            
        }

        System.out.println(sb);

    }
}