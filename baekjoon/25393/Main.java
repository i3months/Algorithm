import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();        

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        Car[] arr = new Car[N];

        String[] tmp1 = br.readLine().split(" ");
        String[] tmp2 = br.readLine().split(" ");

        Queue<Car> q = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];        

        for(int i=0; i<N; i++){
            arr[i] = new Car(i+1, Integer.parseInt(tmp1[i]), Integer.parseInt(tmp2[i]));
        }

        q.add(arr[S - 1]);
        visit[S] = true;

        Arrays.sort(arr);

        while(!q.isEmpty()){
            Car cur = q.poll();
            
            int cur_idx = cur.idx;

            for(int i = cur_idx - 1; i>=0; i--){
                if(arr[i].locate < cur.locate - cur.fuel){
                    break;
                }

                if(visit[arr[i].idx]){
                    continue;
                }
                
                q.add(arr[i]);
                visit[arr[i].idx] = true;
                
            }

            for(int i = cur_idx; i<N; i++){
                if(arr[i].locate > cur.locate + cur.fuel){
                    break;
                }

                if(visit[arr[i].idx]){
                    continue;
                }
                
                q.add(arr[i]);
                visit[arr[i].idx] = true;
                
            }

        }

        for(int i=1; i<N + 1; i++){
            if(visit[i]){
                sb.append(i+ " ");
            }
        }

        System.out.println(sb);

        


	}
}

class Car implements Comparable<Car>{

    int idx, locate, fuel;

    Car(int idx, int locate, int fuel){
        this.idx = idx;
        this.locate =locate;
        this.fuel = fuel;
    }

    public int compareTo(Car o2){
        if(locate > o2.locate){
            return 1;
        }else{
            return -1;
        }
    }
}