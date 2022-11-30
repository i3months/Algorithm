import java.io.*;
import java.util.*;

public class Main {
    final static int INF = 987654321;

    static int[] arr;    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        arr = new int[day+1];
        int[] a = new int[day+1];
        int[] b = new int[day+1];

        a[1] = 1;
        a[2] = 0;

        b[1] = 0;
        b[2] = 1;

        for(int i=3; i<day+1; i++) {
            a[i] = a[i-1] + a[i-2];
            b[i] = b[i-1] + b[i-2];
        }

        for(int i=1; i<num+1; i++) {
            int remainder = num - (a[day] * i);
            if(remainder % b[day] == 0) {
                System.out.println(i + "\n" + remainder / b[day]);
                return;
            }
        }

        
        arr[day] = num;
                

        
    }

    // static int solve(int n) {
        
    //     arr[n] = 
    // }
}