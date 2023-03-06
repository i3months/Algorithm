import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Station> stations = new ArrayList<>();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            stations.add(new Station(a, b));
        }

        Collections.sort(stations);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        int ans = 0;

        while(p < l) {
            while(idx < n && stations.get(idx).location <= p) {
                pq.add(stations.get(idx).gas);
                idx++;
            }

            if(pq.isEmpty()) {
                ans = -1;
                break;
            }

            p += pq.poll();
            ans++;
        }

        System.out.println(ans);


    }
}

class Station implements Comparable<Station>{
    int location;
    int gas;

    Station(int location, int gas) {
        this.location = location;
        this.gas = gas;    
    }

    @Override
    public int compareTo(Station s2) {
        return location - s2.location;
    }
}