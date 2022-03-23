import java.io.*;
import java.util.*;
  public class Main {
    public static void main(String[] args) throws IOException{ 

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      int N1 = Integer.parseInt(br.readLine());
      int N2 = Integer.parseInt(br.readLine());

      if(N==60 && N== N1 && N1 == N2){
        System.out.println("Equilateral");
      }else if(N + N1 + N2 == 180 && (N == N1) || (N1 == N2) || (N == N2)){
        System.out.println("Isosceles");
      }else if(N1 + N2 + N == 180){
        System.out.println("Scalene");
      }else{
        System.out.println("Error");
      }
     
      
    }
  }