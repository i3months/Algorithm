import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++){
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());


			ArrayList<Integer> sejun = new ArrayList<>();
			ArrayList<Integer> sebi = new ArrayList<>();
			
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
			
			for(int j =0; j<N; j++){
				sejun.add(Integer.parseInt(st2.nextToken()));
			}

			for(int k = 0; k<M; k++){
				sebi.add(Integer.parseInt(st3.nextToken()));
			}	

            Collections.sort(sejun);
            Collections.sort(sebi);

            if(sejun.get(sejun.size()-1) > sebi.get(sebi.size()-1)){
                sb.append("S\n");
            }else if(sejun.get(sejun.size()-1) < sebi.get(sebi.size()-1)){
                sb.append("B\n");
            }else{
                int max = sejun.get(sejun.size()-1);
                int cnt1 = 0;
                int cnt2 = 0;
                
                for(int j=0; j<sejun.size(); j++){
                    if(sejun.get(j) == max){
                        cnt1++;
                    }
                } // end of for j

                for(int j=0; j<sejun.size(); j++){
                    if(sebi.get(j) == max){
                        cnt2++;
                    }
                } // end of for j

                if(cnt1>= cnt2){
                    sb.append("S\n");
                }else{
                    sb.append("B\n");
                }

            }

            
			
		}

		System.out.println(sb);




	}
}

		