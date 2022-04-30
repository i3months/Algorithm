import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        int cnt = 0;

        while((input = br.readLine()) != null){
            cnt++;
        }

        System.out.println(cnt);

    }
}