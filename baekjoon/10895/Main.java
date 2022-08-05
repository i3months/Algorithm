import java.util.*;

import javax.naming.Binding;

import java.io.*;
import java.math.*;
import java.rmi.server.SocketSecurityException;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(a == 1){
            System.out.println(1);
            return;
        }

        if(k == 0){
            System.out.println(a);
            return;
        }

        else{
            if(a % 2 == 0){
                System.out.println(1);
            }else{
                System.out.println(a);
            }
        }

        
        
    }
}