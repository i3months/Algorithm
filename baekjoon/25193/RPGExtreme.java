import java.util.*;
import java.io.*;
import java.math.*;

public class RPGExtreme {
   
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        int N = Integer.parseInt(br.readLine())     ;

        String str = br.readLine();

        int chickenCnt = 0;

        for(int i=0; i<N; i++){
            if(str.charAt(i) == 'C'){
                chickenCnt++;
            }
        }

        System.out.println(chickenCnt/(N-chickenCnt+1) + (chickenCnt%(N-chickenCnt+1)!=0?1:0));;;;;;;;;;

    }
    
}

