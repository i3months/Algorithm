import java.io.*;
import java.util.*;

public class Main {

    final static long MAX1 = Long.MAX_VALUE;
    final static int MAX2 = Integer.MAX_VALUE;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long attack;
        long n;

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        attack = Integer.parseInt(st.nextToken());
        
        ArrayList<Node> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));
        }

        long left = 1;
        long right = MAX1 - 100000000;
        long ans = 0;
        long attacks;

        while(left <= right) {
            long mid = (left + right) / 2;
            attacks = attack;
            
            long curHP = mid;
            boolean flag = false;
            
            loop : for(int i=0; i<n; i++) {
                Node cur = list.get(i);

                if(cur.idx == 1) {
                    long attack1 = cur.a;
                    long hp1 = cur.b;

                    // while(true) {

                    //     hp1 -= attacks;
                    //     if(hp1 <= 0) {
                    //         break;
                    //     }

                    //     curHP -= attack1;
                    //     if(curHP <= 0) {
                    //         flag = true;
                    //         break loop;
                    //     }                        
                    // }

                    // if(((hp1) / attacks) > ((curHP) / attack1)) {
                        // flag = true;
                        // break loop;
                    // }

                    // curHP -= ((hp1) / (attacks * attack1));

                    long temp;
                    if(hp1 % attacks == 0) temp = hp1 / attacks - 1;
                    else temp = hp1 / attacks;

                    curHP -= temp * attack1;
                    if(curHP <= 0) {
                        flag = true;
                        break loop;
                    }
                    

                } else {
                    long attack1 = cur.a;
                    long hp1 = cur.b;                    

                    attacks += attack1;
                    curHP = Math.min(mid, curHP + hp1);
                }
                
            }

            if(!flag) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
            
        }

        System.out.println(ans);
    
    
    }   	
}

class Node {
    long idx, a, b;

    Node(long idx, long a, long b) {
        this.idx = idx;
        this.a = a;
        this.b = b;
    }
}