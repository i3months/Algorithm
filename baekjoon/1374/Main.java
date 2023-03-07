import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(b, c));
        }

        Collections.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int cnt = 0;

        for (Lecture lecture : lectures) {
            if (pq.isEmpty()) {
                pq.add(lecture.end);
                cnt++;
            } else {                
                if (pq.peek() <= lecture.start) {
                    pq.poll();
                } else {
                    cnt++;
                }
                pq.add(lecture.end);
            }
        }

        System.out.println(cnt);

    }
}

class Lecture implements Comparable<Lecture> {
    int start;
    int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Lecture l2) {
        return start - l2.start;
        // if(this.end == l2.end) return Integer.compare(start, l2.start);
        // return Integer.compare(end, l2.end);
    }
}