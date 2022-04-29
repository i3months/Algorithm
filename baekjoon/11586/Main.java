import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        char[][] mirror = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                mirror[i][j] = str.charAt(j);
            }
        }

        int condition = Integer.parseInt(br.readLine());

        if (condition == 1) {
            print(mirror);
        }

        if(condition == 2){
            print(left_right(mirror));
        }

        if(condition == 3){
            print(up_down(mirror));
        }

    }

    static void print(char[][] origin) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(origin[i][j]);
            }
            System.out.println();
        }
    }

    static char[][] left_right(char[][] origin) {
        char[][] tmp = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = origin[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                origin[i][j] = tmp[i][N - j - 1];
            }
        }

        return origin;
    }

    static char[][] up_down(char[][] origin) {
        char[][] tmp = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = origin[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                origin[i][j] = tmp[N - i - 1][j];
            }
        }

        return origin;

    }
}