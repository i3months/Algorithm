import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    
  
    for(int i=0; i<N; i++){
  
      int M = sc.nextInt();      
  
      int cnt1 = 0;
      int cnt2 = 0;
  
      for(int j=0; j<M; j++){
  
        char temp1 = sc.next().charAt(0);
        char temp2 = sc.next().charAt(0);                
        
  
        if(temp1 == 'R'){
          if(temp2 == 'S'){
            cnt1++;
          }else if(temp2 == 'P'){
            cnt2++;
          }
  
        }else if(temp1 == 'S'){
          if(temp2 == 'R'){
            cnt2++;
          }else if(temp2 == 'P'){
            cnt1++;
          }
  
        }else if(temp1 == 'P'){
          if(temp2 == 'R'){
            cnt1++;
          }else if(temp2 == 'S'){
            cnt2++;
          }
        }
  
  
      } // end of for j
    
  
      if(cnt1 > cnt2){
        System.out.println("Player 1");
      }else if(cnt1 < cnt2){
        System.out.println("Player 2");
      }else{
        System.out.println("TIE");
      }
  
    }// end of for i
  

  }
}
