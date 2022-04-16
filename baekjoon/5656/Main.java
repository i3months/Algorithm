import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cnt++;
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            int c = Integer.parseInt(st.nextToken());

            if (b.equals(">")) {
                if (a > c) {
                    System.out.println("Case " + cnt + ":" + " true");
                } else {
                    System.out.println("Case " + cnt + ":" + " false");
                }
            }

            if (b.equals("<")) {
                if (a < c) {
                    System.out.println("Case " + cnt + ":" + " true");
                } else {
                    System.out.println("Case " + cnt + ":" + " false");
                }
            }

            if (b.equals(">=")) {
                if (a >= c) {
                    System.out.println("Case " + cnt + ":" + " true");
                } else {
                    System.out.println("Case " + cnt + ":" + " false");
                }
            }

            if (b.equals("<=")) {
                if (a <= c) {
                    System.out.println("Case " + cnt + ":" + " true");
                } else {
                    System.out.println("Case " + cnt + ":" + " false");
                }
            }

            if (b.equals("==")) {
                if (a == c) {
                    System.out.println("Case " + cnt + ":" + " true");
                } else {
                    System.out.println("Case " + cnt + ":" + " false");
                }
            }

            if (b.equals("!=")) {
                if (a != c) {
                    System.out.println("Case " + cnt + ":" + " true");
                } else {
                    System.out.println("Case " + cnt + ":" + " false");
                }
            }

            if(b.equals("E")){
                break;
            }
        }// end of while 



    }
}