import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        
        for(int i=0; i<10; i++){
            arr1[i] = Integer.parseInt(st.nextToken());    
        }
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<10; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        for(int i=0; i<10; i++){
            if(arr1[i] > arr2[i]){
                cnt1++;
            }else if(arr1[i] < arr2[i]){
                cnt2++;
            }
        }
        
        if(cnt1 > cnt2){
            System.out.println('A');
        }else if(cnt1 < cnt2){
            System.out.println('B');
        }else{
            System.out.println('D');
        }
            
    }
}