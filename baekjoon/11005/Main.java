import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    List<Character> num_list = new ArrayList<>();

    while(N > 0){
      if(N % B < 10){
        char temp = (char)(N%B + '0');
        num_list.add(temp);
      }else{
        char temp = (char)(N%B - 10 + 'A');
        num_list.add(temp);
        
      }
      N = N / B;
    }

    for(int i=num_list.size() -1; i >=0; i--){
      System.out.print(num_list.get(i));
    }
    

  }
}