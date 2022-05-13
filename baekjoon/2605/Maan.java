import java.util.*;
import java.io.*;

public class Maan {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				

		int N = Integer.parseInt(br.readLine());

    LinkedList<Integer> list = new LinkedList<>();

    for(int i=1; i<N+1; i++){
      list.add(i);
    }

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i=0;i<N; i++){
      int cmd = Integer.parseInt(st.nextToken());
      int temp = list.remove(i);
      list.add(i-cmd, temp);
    }

    for(int i=0; i<N; i++){
      System.out.print(list.get(i) + " ");
    }


	}
}