import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        String input1 = br.readLine();
        String input2 = br.readLine();

        long inp1 = Long.parseLong(input1,2);
        long inp2 = Long.parseLong(input2,2);
        System.out.println(Long.toBinaryString(inp1 * inp2));
    

    }
}