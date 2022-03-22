import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();


    int K = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int arr[] = new int[5];
    
    for(int i=0; i<5; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    for(int i=0; i<5; i++){
      if(arr[i] == K){
        ans++;
      }

      
    }
    System.out.println(ans);

  }
}