import java.util.*;
import java.io.*;
import java.math.*;

public class Main {							
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
		
		String S = br.readLine();

		int[] arr = new int[S.length()];

		for(int i=0; i<S.length(); i++){
			arr[i] = S.charAt(i) - '0';
		}

		int start, mid, end;
        int s, e; 
        int left, right; 

        end = S.length() % 2 == 0 ? S.length() : S.length() - 1; 

        end += 2; 

        while (end > 2) {
            start = 0;
            end -= 2;
            e = end;
            s = start;

            while (e <= S.length()) { 

                mid = (s + e) / 2;
                left = 0;
                right = 0;

                for (int l = s; l < mid; l++) { 
                    left += arr[l];
                }

                for (int r = mid; r < e; r++) { 
                    right += arr[r];
                }

                if (left == right) {
                    System.out.println(end);
                    return;
                }
                s++;
                e++;
            }
        }
        System.out.println(0);
		

	}
}