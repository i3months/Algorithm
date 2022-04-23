import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String start_time[] = st.nextToken().split(":");
        String finish_time[] = st.nextToken().split(":");
        String end_time[] = st.nextToken().split(":");

        int start = Integer.parseInt(start_time[0]) * 60 + Integer.parseInt(start_time[1]);
        int finish = Integer.parseInt(finish_time[0]) * 60 + Integer.parseInt(finish_time[1]);
        int end = Integer.parseInt(end_time[0]) * 60 + Integer.parseInt(end_time[1]);

        HashSet<String> hs = new HashSet<>();

        String input = "";
        int cnt = 0;

        while((input = br.readLine()) != null){

            //if(input.equals("#")){
            //    break; 
            //}

            String temp[] = input.split(" ");

            String temp_time[] = temp[0].split(":");
            int time = Integer.parseInt(temp_time[0]) * 60 + Integer.parseInt(temp_time[1]);
            String name = temp[1];

            if(time <= start){
                hs.add(name);
            }

            if(time >= finish && time <= end){
                if(hs.contains(name)){
                    hs.remove(name);
                    cnt++;
                }
            }
            

            
        }

        System.out.println(cnt);




        


    }
}
