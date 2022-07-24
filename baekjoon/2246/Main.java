import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        Condo[] arr = new Condo[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Condo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        

        int cnt = 0;

        for(int i=0; i<N; i++){
            boolean chk = false;
            for(int j=0; j<N; j++){
                if(i == j){
                    continue;
                }        

                if(arr[i].dist > arr[j].dist){
                    if(arr[j].price <= arr[i].price){
                        chk = true;
                        break;
                    }
                }

                if(arr[i].price > arr[j].price){
                    if(arr[i].dist >= arr[j].dist){
                        chk = true;
                        break;
                    }
                }
            }

            if(!chk){
                cnt++;
                // System.out.println("ans " + arr[i].dist + " " + arr[i].price);
            }
        }

        System.out.println(cnt);
        
    }
}

class Condo implements Comparable<Condo>{
    int dist, price;

    Condo(int dist, int price){
        this.dist = dist;
        this.price = price;
    }

    public int compareTo(Condo o2){
        if(dist > o2.dist){
            return 1;
        }else if(dist < o2.dist){
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
 
