import java.util.*;

import javax.swing.event.SwingPropertyChangeSupport;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int ans = 0;

        Present[] arr = new Present[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Present(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i == j){
                    arr[j].sum = (arr[j].price / 2) + arr[j].delivery;
                    // System.out.println("?asdf " + arr[j].sum + arr[j].price);
                }else{
                    arr[j].sum = arr[j].price + arr[j].delivery;
                }                                
            }

            // for(Present k : arr){
            //     System.out.print(k.price + " ");                
            // }
            // System.out.println();

            Arrays.sort(arr);
            long tmp_sum = 0;
            int cnt = 0 ;

            for(int j=0; j<N; j++){
                tmp_sum += arr[j].sum;
                if(tmp_sum > B){                    
                    break;
                }
                cnt++;
                // System.out.println("c" + cnt);
            }

            ans = Math.max(ans, cnt);
        }
        // if(N == 2 && B == 1){
        //     System.out.println(1);
        //     return;
        // }
        System.out.println(ans);   
    }    
}

class Present implements Comparable<Present>{
    long price, delivery, sum;

    Present(long price, long delivery){
        this.price = price;        
        this.delivery = delivery;            
    }

    public int compareTo(Present o2){
        if(sum > o2.sum){
            return 1;
        }else if(sum < o2.sum){
            return -1;
        }else{
            if(price > o2.price){
                return 1;
            }else{
                return -1;
            }
        }
    }
}