import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{  
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;

    Member[] members = new Member[N];
    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine(), " ");

      members[i] = new Member(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

    }
    
    Arrays.sort(members, new Comparator<Member>(){
      public int compare(Member o1, Member o2){
       if(o1.korean > o2.korean){
         return -1;
       } else if(o1.korean < o2.korean){
         return 1;
       }else{
         if(o1.english > o2.english){
           return 1;
         }else if(o1.english < o2.english){
           return -1;
         }else{
           if(o1.math > o2.math){
             return -1;
           }else if(o1.math < o2.math){
             return 1;
           }else{
             return o1.name.compareTo(o2.name);                           
           }
         }
       }
      }

    });

    for(int i=0; i<N; i++){
      sb.append(members[i].name).append("\n");
    }

    System.out.println(sb);


  }
}

class Member{
  String name;
  int korean;
  int english;
  int math;

  Member(String a, int b, int c, int d){
    name = a;
    korean = b;
    english = c;
    math = d;
  }
}

