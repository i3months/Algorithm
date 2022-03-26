import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int a3 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(),":");
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        int b3 = Integer.parseInt(st.nextToken());

        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;

        ans3 = b3 - a3;

        boolean chk1 = false;

        if(ans3 < 0){
            ans3 = 60 + ans3;    
            chk1 = true;
        }

        boolean chk2 = false;

        ans2 = b2 - a2;

        if(chk1){
            ans2 = ans2 - 1;        
        }

        if(ans2 < 0){
            ans2 = 60 + ans2;
            chk2 = true;
        }

        boolean chk3 = false;

        ans1 = b1 - a1;

        if(chk2){
            ans1 = ans1 -1;
        }

        if(ans1 < 0){
            ans1 = 60 + ans1;
        }

        String ans1_str = "";

        if(ans1<10){
            ans1_str = "0" + String.valueOf(ans1);
        }else{
            ans1_str = String.valueOf(ans1);
        }
        String ans2_str = "";
        if(ans2<10){
            ans2_str = "0" + String.valueOf(ans2);
        }else{
            ans2_str = String.valueOf(ans2);
        }
        String ans3_str = "";
        if(ans3<10){
            ans3_str = "0" + String.valueOf(ans3);
        }else{
            ans3_str = String.valueOf(ans3);
        }



        System.out.println(ans1_str + ":" + ans2_str + ":" + ans3_str);
        
        

        
    }

    
}