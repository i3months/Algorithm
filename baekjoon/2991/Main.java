import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr1 = new int[1000];
        int[] arr2 = new int[1000];

        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int c3 = Integer.parseInt(st.nextToken());

/////
        int temp1 = c1 % (a1 + a2);

        int cnt1 = 0;

        if(temp1 >=1 && temp1 <= a1){
            cnt1++;    
        }

        temp1 = c1 % (b1 + b2);

        if(temp1 >=1 && temp1 <= b1){
            cnt1++;    
        }

        System.out.println(cnt1);
////
        int temp2 = c2 % (a1 + a2);

        int cnt2 = 0;

        if(temp2 >=1 && temp2 <= a1){
            cnt2++;    
        }

        temp2 = c2 % (b1 + b2);

        if(temp2 >=1 && temp2 <= b1){
            cnt2++;    
        }

        System.out.println(cnt2);
////

        int temp3 = c3 % (a1 + a2);

        int cnt3 = 0;

        if(temp3 >=1 && temp3 <= a1){
            cnt3++;    
        }

        temp3 = c3 % (b1 + b2);

        if(temp3 >=1 && temp3 <= b1){
            cnt3++;    
        }

        System.out.println(cnt3);
        
        

    }
}

