import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    for(int i=0; i<3; i++){

      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String[] str_clock_1 = st.nextToken().split(":");
      String[] str_clock_2 = st.nextToken().split(":");
      int ans = 0;

      int clock_hour_1 = Integer.parseInt(str_clock_1[0]);
      int clock_min_1 = Integer.parseInt(str_clock_1[1]);
      int clock_sec_1 = Integer.parseInt(str_clock_1[2]);

      int clock_hour_2 = Integer.parseInt(str_clock_2[0]);
      int clock_min_2 = Integer.parseInt(str_clock_2[1]);
      int clock_sec_2 = Integer.parseInt(str_clock_2[2]);

      int clocktime = Integer.parseInt(str_clock_1[0]+str_clock_1[1]+str_clock_1[2]);

      while(true){
  
       
        if(clocktime % 3 == 0){
          ans++;
        }

        if(clock_hour_1 == clock_hour_2 && clock_min_1 == clock_min_2 &&clock_sec_1 == clock_sec_2 ){
          break;
        }

        clock_sec_1++;

        if(clock_sec_1 == 60){
          clock_sec_1 = 0;
          clock_min_1++;
        }

        if(clock_min_1 == 60){
          clock_min_1 = 0;
          clock_sec_1 =0;
          clock_hour_1++;
        }

        if(clock_hour_1 == 24){
          clock_hour_1 = 0;
          clock_min_1 = 0;
          clock_sec_1 = 0;
        }

        String str_clock_hour_1;
        String str_clock_min_1;
        String str_clock_sec_1;

        if(clock_sec_1 < 10){
          str_clock_sec_1 = "0" + String.valueOf(clock_sec_1);
        }else{
          str_clock_sec_1 = String.valueOf(clock_sec_1);
        }

        if(clock_min_1 < 10){
          str_clock_min_1 = "0" + String.valueOf(clock_min_1);
        }else{
          str_clock_min_1 = String.valueOf(clock_min_1);
        }

        str_clock_hour_1 = String.valueOf(clock_hour_1);

        String str_clocktime = str_clock_hour_1 + str_clock_min_1 + str_clock_sec_1;

        clocktime = Integer.parseInt(str_clocktime);
        
        
        
          

        
      }
      sb.append(ans).append('\n');
      
    }
    System.out.println(sb);



    
  }
}