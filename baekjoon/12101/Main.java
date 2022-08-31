import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();     
    static boolean chk;
    static int N, K, cnt;
    static ArrayList<String> list = new ArrayList<>();
    static int[] arr = new int[100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                    
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bt(0,0);  
        
        if(!chk){
            System.out.println(-1);
        }
        
    }

    static void bt(int sum, int idx){
        if(sum == N){
            cnt++;

            if(cnt == K){
                chk = true;
                String str = "";
                for(int i=0; i<idx; i++){
                    str += String.valueOf(arr[i]);
                    str += "+";
                }     
                System.out.println(str.substring(0,str.length()-1));
            }
                        

            return;
        }

        for(int i=1; i<4; i++){
            int val = sum + i;
            if(val > N){
                continue;
            }         

            sum = val;
            arr[idx] = i;
            bt(sum, idx + 1);
            sum -= i;
        }
        
        

        
    }
}