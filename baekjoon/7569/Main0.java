import java.io.*;
import java.util.*;

public class Main0 {

  static int N;  // 세로
  static int M;  // 가로
  static int H; // 높이

  static int[] dx = { -1, 0, 1, 0, 0, 0 }; // row
  static int[] dy = { 0, 1, 0, -1, 0, 0 }; // column
  static int[] dz = { 0, 0, 0, 0, 1, -1 }; // height

  static int[][][] map;

  static Queue<Tomato> q;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken()); // 가 세 높
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new int[H][N][M];

    q = new LinkedList<>();

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          int temp = Integer.parseInt(st.nextToken());
          map[i][j][k] = temp;
          if (temp == 1) {
            q.add(new Tomato(i, j, k));
          }
        }
      }
    }


   System.out.println(bfs());

  }

  static class Tomato {
    int x;
    int y;
    int z;

    Tomato(int a, int b, int c) {
      z = a;
      x = b;
      y = c;
    }
  }

  static int bfs() {

    while (!q.isEmpty()) {
      Tomato tomato = q.remove();

      int x = tomato.x;
      int y = tomato.y;
      int z = tomato.z;

      for (int i = 0; i < 6; i++) {
        int move_x = x + dx[i];
        int move_y = y + dy[i];
        int move_z = z + dz[i];

        if (move_x >= 0 && move_y >= 0 && move_z >= 0 && move_x < N && move_y < M && move_z < H) {
          if(map[move_z][move_x][move_y] == 0){
            q.add(new Tomato(move_z, move_x, move_y));

            map[move_z][move_x][move_y] = map[z][x][y] + 1;
          }
        }
      }// end of for i 
    }// end of while

    int ans = 0;
    for(int i=0; i<H; i++){
      for(int j=0; j<N; j++){
        for(int k=0; k<M; k++){
          if(map[i][j][k] == 0){
            return -1;
          }
          ans = Math.max(ans, map[i][j][k]);
        }
      }
    }

    if(ans == 1){
      return 0;
    }else
    return ans -1;

  }
}