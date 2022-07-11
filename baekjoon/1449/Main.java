import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Pipe[] arr = new Pipe[N];

		st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++){
			int tmp = Integer.parseInt(st.nextToken());

			arr[i] = new Pipe(tmp - 0.5, tmp + 0.5);
		}

		Arrays.sort(arr);

		int cnt = 1;

		double tape_start = arr[0].start;
		double tape_end = arr[0].start + L;

		for(int i=1; i<N; i++){
			
			if(arr[i].start > tape_start && arr[i].end < tape_end){
				continue;
			}
			
			if(arr[i].start > tape_start && arr[i].end > tape_end && arr[i].start < tape_end){
				cnt++;
				tape_start = tape_end;
				tape_end = tape_start + L;
			}

			if(arr[i].start > tape_start && arr[i].end > tape_end){
				cnt++;
				tape_start = arr[i].start;
				tape_end = tape_start + L;
			}

		}


		System.out.println(cnt);

	}
}

class Pipe implements Comparable<Pipe>{
	double start, end;

	Pipe(double a, double b){
		start = a;
		end = b;
	}

	public int compareTo(Pipe o2){
		if(start >= o2.start){
			return 1;
		}else{
			return -1;
		}

	}
}