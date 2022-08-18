import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int[] select;
    static char[] operators;
    static int N;
    static boolean[] visit;

    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        N = Integer.parseInt(br.readLine());
        select = new int[N + 1];
        operators = new char[N];
        visit = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            operators[i] = st.nextToken().charAt(0);
        }

        bt(0);

        

        System.out.println(String.valueOf(max).length() == N+1 ? max : "0" + String.valueOf(max));
        System.out.println(String.valueOf(min).length() == N+1 ? min : "0" + String.valueOf(min));
        
        
    }

    static void bt(int depth){
        
        if(depth == N + 1){
            // calculate
            String tmp = "";

            for(int i =0; i< select.length; i++){
                tmp += String.valueOf(select[i]);
            }

            long num = Long.parseLong(tmp);

            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }


        for(int i=0; i<10; i++){
            if(!visit[i]){
                if(depth == 0){
                    visit[i] = true;
                    select[depth] = i;
                    bt(depth + 1);   
                    visit[i] = false;
                    select[depth] = 0;
                }else{
                    if(operators[depth - 1] == '<'){
                        if(select[depth - 1] > i){
                            continue;
                        }
                        visit[i] = true;
                        select[depth] = i;
                        bt(depth + 1);
                        visit[i] = false;
                        select[depth] = 0;
                    }

                    if(operators[depth - 1] == '>'){
                        if(select[depth - 1] < i){
                            continue;
                        }
                        visit[i] = true;
                        select[depth] = i;
                        bt(depth + 1);
                        visit[i] = false;
                        select[depth] = 0;
                    }
                    
                }
            }
        }

    }

}