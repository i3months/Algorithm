import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    
    int n1 = 0;
    int n2 = 0;
    int temp1 = 0;
    int temp2 = 0;

    for(int i=0; i<N; i++){
      if(i == 0 || i == 1){
        n1 = n2;
        n2 = 1;
      }else{
        temp1 = n1;
        temp2 = n2;
        n1 = temp2;
        n2 = temp1+temp2;
      }
    }
    System.out.println(n2);
    

  }

}