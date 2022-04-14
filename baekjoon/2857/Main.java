    import java.util.*;
    import java.io.*;

    public class Main{
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            boolean chk = false;

            for(int i=1; i<6; i++){
                String str = br.readLine();
                for(int j=0; j<str.length()-2; j++){
                    if(str.charAt(j) == 'F' &&str.charAt(j+1) == 'B' && str.charAt(j+2) =='I'){
                        chk = true;
                        sb.append(i + " ");
                        break;
                    }
                }
            }

            System.out.print(sb);

            if(!chk){
                System.out.println("HE GOT AWAY!");
            }
        }
    }