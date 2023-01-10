// import java.io.*;
// import java.util.*;
// import java.math.*;
 
// public class Main {    
//     static StringBuilder sb = new StringBuilder(); 
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                              

//         int TC = Integer.parseInt(br.readLine());

//         while(TC-- > 0) {            
//             String str = br.readLine();

//             PriorityQueue<String> pq = new PriorityQueue<>();

//             int len = str.length();

//             boolean chk = false;

//             loop : for(int i=0; i<len-1; i++) {
//                 for(int j=i+1; j<len-1; j++) {
//                     String a = str.substring(0, i+1);
//                     String b = str.substring(i+1, j+1);
//                     String c = str.substring(j+1, len);

//                     pq.add(a);
//                     pq.add(b);
//                     pq.add(c);

//                     String first = pq.poll();
//                     String second = pq.poll();
//                     String third = pq.poll();

//                     if(first.equals(b) || third.equals(b)) {
//                         chk = true;
//                         System.out.println(a + " " + b + " " + c);
//                         break loop;
//                     }
                    
//                 }
//             }         
            
//             if(!chk) {
//                 System.out.println(": (");
//             }

//         }
        
//     }
// }
