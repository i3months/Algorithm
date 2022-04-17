import java.util.*;

public class Main {
  static int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    int len = truck_weights.length;
    int[] b = new int[len];
    int bridgeTruck = 0;
    int i = 0, j = 0, k = 0;
    while (true) {
      while ((bridgeTruck + truck_weights[j]) <= weight && k == 0) {
        answer += 1;
        bridgeTruck += truck_weights[j];
        b[j] = answer + bridge_length; // 2, 3, 3
        if (j >= 1) {
          if (b[j] <= b[j - 1])
            b[j] = b[j-1] + 1;
        }
        if (j == len - 1) {
          k = 1;
          break;
        }
        j++;
      }
      answer = b[i];
      bridgeTruck -= truck_weights[i];
      if (i == len - 1)
        break;
      i++;
      answer -= 1;
    }

    return answer;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int n = kbd.nextInt();
    int a = kbd.nextInt();
    int x = kbd.nextInt();
    int[] b = new int[n];
    for (int i = 0; i < n; i++)
      b[i] = kbd.nextInt();
    System.out.println(solution(a, x, b));
  }
}
