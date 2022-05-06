import java.util.*;
import java.io.*;

public class Main {

	static char[][] arr;
	static int R;
	static int C;

	static HashMap<String, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];

		for(int i=0; i<R; i++){
			String str = br.readLine();
			for(int j=0; j<C; j++){
				arr[i][j] = str.charAt(j);
			}
		}		

		System.out.println(BinarySearch());

		/*
		boolean chk = true;
		int cnt = 0;
		int start = 0;
		StringBuilder sb = new StringBuilder();		

		while(true){
			
			for(int i = 0; i<C; i++){				
				sb.setLength(0);	

				for(int j=start; j<R; j++){
					sb.append(""+ arr[j][i]);					
				}
				///
				//System.out.println(temp);				
				///

				if(!hm.containsKey(sb.toString())){
					hm.put(sb.toString(), 1);
				}else{
					chk = false;
					break;
				}
			}

			if(!chk){
				System.out.println(cnt-1);
				break;
			}else{
				cnt++;
				start++;
				//System.out.println("zzzzzzzzzzzz");
			}

		}
*/////////////////////////////////////
		
	}

	static int BinarySearch(){
		int Left = 1;
		int Right = R -1;
		int ans = 0;

		while(Left <= Right){
			int mid = (Left + Right) / 2;
			if(check(mid)){
				ans = mid;
				Left = mid + 1;				
			}else{
				Right = mid - 1;
			}
		}

		return ans;

		
	}

	static boolean check(int start){

		for(int i=0; i<C; i++){
			String temp = "";
			for(int j=start; j<R; j++){
				temp = temp + arr[j][i];
			}
			if(!hm.containsKey(temp)){
				hm.put(temp, 1);
			}else{
				return false;
			}
		}

		return true;
		
		

	}

}