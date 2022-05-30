    import java.util.*;
    import java.io.*;

    public class Main {	
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            boolean prime[] = new boolean[10000001];		

            int N = 10000000; // fix need?
            prime[0] = prime[1] = true;

            for(int i=2; i*i <= N; i++){
                if(!prime[i]){
                    for(int j = i * i; j<= N; j = i + j){
                        prime[j] = true;
                    }
                }
            }


            int T = Integer.parseInt(br.readLine());

            while(true){            
                
                if(T == 0){
                    break;
                }

                T--;
                int M = Integer.parseInt(br.readLine());
                
                int a = 0;
                int b = Integer.MAX_VALUE;

                for(int i=2; i<M; i++){

                    if(!prime[i]){
                        if(!prime[M - i]){

                            if(b - a > i - (M - i)){
                                a = i;
                                b = M - i;
                            }
                            
                        }
                    }

                }

                if(a == 0 && b == 0){
                    sb.append("Goldbach's conjecture is wrong.\n");
                }else{
                    sb.append(a + " " + b + "\n");
                }			                

            }
            

            System.out.print(sb);

            
            
            
        }
        
    }
