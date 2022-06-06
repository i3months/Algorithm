import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb3 = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for(int i=0; i<T; i++){
      int N = Integer.parseInt(br.readLine());
      String[] arr = new String[N];

      for(int j=0; j<N; j++){
        arr[j] = br.readLine();
      }

      String tmp = "";
      boolean chk = false;

      for(int k=0; k<N; k++){
        for(int m=0; m<N-1; m++){
          if(k == m){
            continue;
          }

          StringBuilder sb = new StringBuilder();

          tmp = arr[k] + arr[m];

          sb.append(tmp);
          String reverse_tmp = sb.reverse().toString();

          if(tmp.equals(reverse_tmp)){
            chk = true;
            sb3.append(tmp + "\n");
            //System.out.println(tmp);
            break;
          }

          String tmp2 = arr[m] + arr[k];

          StringBuilder sb2 = new StringBuilder();

          sb2.append(tmp2);
          String reverse_tmp2 = sb.reverse().toString();

          if(tmp2.equals(reverse_tmp2)){
            chk = true;
            //System.out.println(tmp2);
            sb3.append(tmp2 + "\n");
            break;
          }

        }   
        if(chk){
          break;
        }     
      }

      if(!chk){
        //System.out.println(0);
        sb3.append(0 + "\n");
      }

    }

    System.out.print(sb3);

  }
}