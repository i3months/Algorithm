import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int capacity = Integer.parseInt(br.readLine());

        long ans = 0;

        for(int i=0; i<N; i++){
            if(arr[i]==0){
                continue;
            }else{
                if(arr[i] % capacity == 0){
                    ans = ans + ((arr[i] / capacity) ) * capacity;
                }else{
                    ans = ans + ((arr[i] / capacity) + 1) * capacity;
                }
               
            }
        }

        System.out.println(ans);

    }
}

