    import java.util.*;
    import java.io.*;

    public class Main {
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            String num1 = st.nextToken();
            String num2 = st.nextToken();
 
            long sum = 0;
            for(int i=0; i<num1.length(); i++){
                for(int j=0; j<num2.length(); j++){
                    long temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    sum = sum + temp;
                }
            }

            System.out.println(sum);


            
        }

    }

