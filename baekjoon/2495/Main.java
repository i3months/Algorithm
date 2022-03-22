import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();


    for(int i=0; i<3; i++){
      String str = br.readLine();
      int ans = 1;
      int[] arr = new int[str.length()];
      for(int j=0 ;j<str.length()-1; j++){
        if(str.charAt(j) == str.charAt(j+1)){
          ans++;
          arr[j] = ans;
        }else{
          ans = 1;
          arr[j] = ans;
        }
      }
      Arrays.sort(arr);
      int asdf = arr[str.length()-1];
      sb.append(asdf+"\n");
      

    }
   
    System.out.println(sb);
  }
}