import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    StringTokenizer st2 = new StringTokenizer(br.readLine());

    int main = Integer.parseInt(st2.nextToken());
    int sub = Integer.parseInt(st2.nextToken());
    int ans = 0;

    for(int i=0; i<N; i++){  
      int temp = 0;
      temp = arr[i] - main;
      ans++;
      if(temp<=0){
        continue;
      }else{
        int temp1 = temp / sub;
        int temp2 = 0;
        if(temp % sub > 0){
          temp2 = 1;
        }
        
        ans = ans + temp1;
        ans = ans + temp2;
      }

    }

    System.out.println(ans);

    
  }
}