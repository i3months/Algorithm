    import java.util.*;
    import java.io.*;
    import java.math.*;

    public class Main {        
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());            

            ArrayList<int[]>[] list = new ArrayList[N+1];

            for(int i=1; i<N+1; i++){
                list[i] = new ArrayList<>();                
            }

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(a < b){
                    list[a].add(new int[]{b,c});
                }
            }

            int[][] dp = new int[N+1][N+1];
            
            for(int[] k : list[1]){
                int city = k[0];
                int food = k[1];

                dp[city][2] = Math.max(dp[city][2], food);
            }

            for(int i=2; i<M+1; i++){
                for(int cur = 1; cur<N+1; cur++){
                    if(dp[cur][i] != 0){
                        for(int j=0; j<list[cur].size(); j++){
                            int city = list[cur].get(j)[0];
                            int food = list[cur].get(j)[1];

                            dp[city][i+1] = Math.max(dp[city][i+1], food + dp[cur][i]);
                        }
                    }
                }
            }

            int ans = 0;

            for(int i=2; i<M+1; i++){
                ans = Math.max(ans, dp[N][i]);
            }

            System.out.println(ans);


        }    
    }
