import java.util.*;
import java.io.*;

public class Main01 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    long ans = 0;

    Queue[] q = new Queue[21];

    for (int i = 0; i < 21; i++) {
      q[i] = new LinkedList<>();
    }

    for (int i = 0; i < N; i++) {
      int len = br.readLine().length();

      if (q[len].isEmpty()) { // 문자열의 길이로 접근
        q[len].offer(i);
      } else {
        while (i - (int)q[len].peek() > K) { // 좋은 친구의 쌍을 찾기
          q[len].poll();
          if (q[len].isEmpty()) {
            break;
          }
        } // end of while

        ans = ans + q[len].size();
        q[len].offer(i);
      }

    }

    System.out.println(ans);

  }
}
