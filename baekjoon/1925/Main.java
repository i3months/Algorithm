import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int arr[][] = new int[3][2];
        for (int i = 0; i < 3; i++) {
            String str[] = br.readLine().split(" ");
            arr[i] = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        }
 
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {                
                return Integer.compare(o1[0], o2[0]);
//                return 0;
            }
 
        });
 
        if (arr[0][0]*arr[1][1]+arr[1][0]*arr[2][1]+arr[2][0]*arr[0][1]-(arr[1][0]*arr[0][1]+arr[2][0]*arr[1][1]+arr[0][0]*arr[2][1])!=0) {
            double tri[] = new double[3];
            tri[0] = Math.sqrt(Math.pow((arr[0][0] - arr[1][0]), 2) + Math.pow(arr[0][1] - arr[1][1], 2));
            tri[1] = Math.sqrt(Math.pow((arr[0][0] - arr[2][0]), 2) + Math.pow(arr[0][1] - arr[2][1], 2));
            tri[2] = Math.sqrt(Math.pow((arr[1][0] - arr[2][0]), 2) + Math.pow(arr[1][1] - arr[2][1], 2));
 
            Arrays.sort(tri);
 
            if (tri[0] == tri[1] && tri[1] == tri[2] && tri[0] == tri[2]) {
                sb.append("JungTriangle");
            } else if ((tri[0] - tri[1] == 0) || (tri[0] - tri[2] == 0) || (tri[1] - tri[2] == 0)) {
                if (Math.sqrt(Math.pow(tri[0], 2) + Math.pow(tri[1], 2)) == tri[2]) {
                    sb.append("Jikkak2Triangle");
                } else if (Math.sqrt(Math.pow(tri[0], 2) + Math.pow(tri[1], 2)) > tri[2]) {
                    sb.append("Yeahkak2Triangle");
                } else {
                    sb.append("Dunkak2Triangle");
                }
            } else {
                if (Math.sqrt(Math.pow(tri[0], 2) + Math.pow(tri[1], 2)) == tri[2]) {
                    sb.append("JikkakTriangle");
                } else if (Math.sqrt(Math.pow(tri[0], 2) + Math.pow(tri[1], 2)) > tri[2]) {
                    sb.append("YeahkakTriangle");
                } else {
                    sb.append("DunkakTriangle");
                }
            }
 
        } else {
            sb.append("X");
        }
        System.out.println(sb);
        br.close();
    }
}
 
