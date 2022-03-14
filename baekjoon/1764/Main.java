import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int cnt = 0;
    HashSet<String> hs = new HashSet<>();

    ArrayList<String> list = new ArrayList<>();

    for(int i=0; i<N; i++){
      hs.add(br.readLine());
    }

    for(int i=0; i<K; i++){
      String temp = br.readLine();
      if(hs.contains(temp)){
        cnt++;
        list.add(temp);
      }
    }

    Collections.sort(list);

    for(int i=0; i<list.size(); i++){
      System.out.println(list.get(i));
    }
    
  }

}