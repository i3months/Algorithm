import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
      
        String[] arr_1 = br.readLine().split(" "); 
        int[] arr = new int[5];

        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(arr_1[i]);
        }
        Arrays.sort(arr);
        int ans = 0;

        if(arr[4] < arr[3]+arr[2]){
            ans++;
        }
        if(arr[4] < arr[3]+arr[1]){
            ans++;
        }
        if(arr[4] < arr[3]+arr[0]){
            ans++;
        }
        if(arr[4] < arr[2]+arr[1]){
            ans++;
        }
        if(arr[4] < arr[2]+arr[0]){
            ans++;
        }
        if(arr[4] < arr[1]+arr[0]){
            ans++;
        }
        if(arr[3] < arr[2]+arr[1]){
            ans++;
        }
        if(arr[3] < arr[0]+arr[2]){
            ans++;
        }
        if(arr[3] < arr[1]+arr[0]){
            ans++;
        }
        if(arr[2] < arr[1]+arr[0]){
            ans++;
        }
        System.out.println(ans);
        
   
    }
}