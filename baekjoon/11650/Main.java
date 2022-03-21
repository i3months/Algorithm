import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][2];

    StringTokenizer st; // 미리 선언해서 메모리 아끼기

    for(int i =0;i<n;i++){
      st = new StringTokenizer(br.readLine());
      arr[i][0]=Integer.parseInt(st.nextToken()); 
      arr[i][1]=Integer.parseInt(st.nextToken()); 
    }

    // arr은 2차원 배열이다.

     Arrays.sort(arr ,new Comparator<int[]>(){
      @Override
      public int compare(int[] p1, int[] p2){
        if(p1[0] == p2[0] ) //x좌표가 동일하면
          return Integer.compare(p1[1],p2[1]); //y좌표 비교
        else  //x좌표가 다르면
          return Integer.compare(p1[0],p2[0]); //x좌표 비교
      }
    });
    // compare메서드는 앞에가 작으면 음수, 같으면 0 뒤에가 작으면 양수를 반환함.


    
    StringBuilder sb = new StringBuilder();
    for(int i =0; i <n;i++){
      sb.append(arr[i][0]+ " "+ arr[i][1]).append('\n');
    }  // 출력
   
    System.out.println(sb);

  }
}
