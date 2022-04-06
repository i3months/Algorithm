import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        for(int i=0;i<N; i++){
            String str = br.readLine();

            int[] arr = new int[10];

            for(int j=0; j<str.length(); j++){
                arr[str.charAt(j) - '0']++;    
            
            }

            int ans = 0;

            for(int j=0; j<10; j++){
                if(arr[j]>0){
                    ans++;
                }
            }

            System.out.println(ans);
        }


	}

}