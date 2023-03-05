import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            stack.add(cur);

            if (stack.size() >= 4 && stack.peek() == 'P' && stack.get(stack.size() - 2) == 'A'
                    && stack.get(stack.size() - 3) == 'P' && stack.get(stack.size() - 4) == 'P') {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                stack.add('P');                
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }

    }
}
