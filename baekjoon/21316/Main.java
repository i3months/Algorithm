import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer>[] list = new ArrayList[13];

        for(int i = 1; i<13; i++){
            list[i] = new ArrayList<>();        
        }

        int[] arr = new int[13];

        for(int i=1; i<13; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
            arr[a]++;
            arr[b]++;
        }
        

        for(int i=1; i<13; i++){            
            if(list[i].size() == 3){
                int sum = 0;

                for(int k : list[i]){
                    sum += arr[k];
                }
                if(sum == 6){
                    System.out.println(i);
                    return;
                }
            }
        }

    }
}