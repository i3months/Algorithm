import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();    
    static int N, max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
        
        N = Integer.parseInt(br.readLine());

        Meeting[] arr = new Meeting[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());        
            arr[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));    
        }        

        int[] dp = new int[N];

        dp[0] = arr[0].person;        

        int res = -1234;

        if(N >= 1){
            res = dp[0];
        }

        if(N >= 2){
            dp[1] = arr[1].person;            
        }
        
        for(int i=2; i < N; i++){
            dp[i] = arr[i].person + res;            
            res = Math.max(res, dp[i - 1]);
        }

        res = Math.max(res, dp[N - 1]);

        System.out.println(res);
        
    
    }
}

class Meeting {
    int start, end, person;

    Meeting(int start, int end, int person){
        this.start = start;
        this.end = end;
        this.person = person;
    }
}