import java.util.*;
import java.io.*;

public class Main{
  static int X;
  static int Y;

  static int target;
  static int ans = -1;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    target = (int)((long)Y * 100 / (long) X);

    BinarySearch();

    System.out.println(ans);
    
    
    
    

  }

  static void BinarySearch(){
    int L = 0;
    int R = 1000000000;

    while(L <= R){
      int mid = (L+R) / 2;
      if((int)((long)(Y + mid) * 100 / (long) (X + mid)) != target){
        ans = mid;
        R = mid - 1;
      }else{
        L = mid + 1;
      }

    }
  }
}