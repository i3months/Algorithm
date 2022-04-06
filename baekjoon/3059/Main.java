import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        for(int i=0;i<N; i++){
            String str = br.readLine();
            int[] arr = new int[100];
            
            for(int j=0; j<str.length(); j++){
                arr[str.charAt(j)]++;
            }

            int ans = 0;

            for(int j=65; j<91; j++){
                if(arr[j] == 0){
                    ans = ans + j;
                }
            }

            System.out.println(ans);
        }


	}

}