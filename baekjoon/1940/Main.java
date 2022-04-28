import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }


        int cnt = 0;

        for(int i=0; i<N-1; i++){
            int a = list.get(i);
            int b = M - a;
            for(int j=i+1; j<N; j++){
                if(list.get(j) == b){
                    list.set(i, -1000000000);
                    list.set(j, -1000000000);
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}