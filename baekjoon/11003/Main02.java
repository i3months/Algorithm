import java.io.*;
import java.util.*;

public class Main02 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    Deque<int[]> q = new ArrayDeque<>();

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      int temp = Integer.parseInt(st.nextToken());

      while (!q.isEmpty() && q.peekLast()[0] > temp){
        q.pollLast();
      }

      q.offer(new int[] { temp, i });
      
      if (q.peek()[1] < i - (L - 1)) {
        q.poll();
      }
      sb.append(q.peek()[0] + " ");
      
    }
    System.out.println(sb);
  }
}