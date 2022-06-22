import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		Robot[] arr = new Robot[N];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));			
		}
		
		Seq[] ans = new Seq[N];

		for(int i=0; i<N; i++){
			double tmp1 = (double)Math.abs(arr[i].x);
			double tmp2 = (double)Math.abs(arr[i].y);
			tmp1 = tmp1 * tmp1;
			tmp2 = tmp2 * tmp2;

			double tmp3 = Math.sqrt(tmp1 + tmp2) / (double)arr[i].d;

			ans[i] = new Seq(tmp3, i+1);
		}

		Arrays.sort(ans);

		for(int i=0; i<N; i++){
			System.out.println(ans[i].num);
		}

		

	}
}

class Seq implements Comparable<Seq>{
	double val;
	int num;

	Seq(double a, int b){
		val = a;
		num = b;
	}

	public int compareTo(Seq o2){
		if(val > o2.val){
			return 1;
		}else if(val < o2.val){
			return -1;
		}else{
			if(num > o2.num){
				return 1;
			}else{
				return -1;
			}
		}
	}
}

class Robot{
	int x;
	int y;
	int d;
	Robot(int a, int b, int c){
		x = a;
		y = b;
		d = c;
	}
	
}