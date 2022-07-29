import java.io.*;
import java.util.*;
 
public class Main { 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Queue<Number> q = new LinkedList<>();
        q.add(new Number(A,0));

        while(!q.isEmpty()){
            Number cur = q.poll();

            if(cur.num > B){
                continue;
            }

            if(cur.num == B){
                System.out.println(cur.cnt + 1);
                return;
            }

            long num2 = cur.num * 2;
            q.add(new Number(num2, cur.cnt + 1));

            long num3 = Long.parseLong(String.valueOf(cur.num) + "1");
            q.add(new Number(num3, cur.cnt + 1));

            
        }

        System.out.println(-1);
        

        
    }
}

class Number{
    long num;
    int cnt;

    Number(long num, int cnt){
        this.num = num;
        this.cnt = cnt;
    }
}