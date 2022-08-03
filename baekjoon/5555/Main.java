import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    
    static int dir = 2;

    static int N, M, x, y;

    static boolean chk = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String target = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        for(int i=0; i<N;i ++){
            String str = br.readLine();            
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == target.charAt(0)){
                    if(j + target.length() <= str.length()){
                        String cmp = str.substring(j, j + target.length());
                        if(cmp.equals(target)){
                            cnt++;
                            break;
                        }
                    }else{
                        String cmp = str.substring(j, str.length());
                        cmp = cmp + str.substring(0, j + target.length() - (str.length()));
                        if(cmp.equals(target)){
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}