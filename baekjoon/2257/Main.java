import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Integer> st = new Stack<>();

        int cnt = 0;
        int save = 0;

        st.push(0);

        for (int i = 0; i < str.length(); i++) {
            char cmd = str.charAt(i);

            switch (cmd) {
                case 'H':                    
                    int temp = st.pop();
                    temp = temp + 1;
                    st.push(temp);
                    save = 1;
                    break;

                case 'C':
                    int temp1 = st.pop();
                    temp1 = temp1 + 12;
                    st.push(temp1);
                    save = 12;
                    break;

                case 'O':
                    int temp2 = st.pop();
                    temp2 = temp2 + 16;
                    st.push(temp2);
                    save = 16;
                    break;

                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    int temp3 = st.pop();
                    temp3 = temp3 + save * (cmd - '0' - 1);
                    st.push(temp3);
                    break;

                case '(':
                    st.push(0);
                    break;

                case ')':
                int temp4 = st.pop();
                save = temp4;
                int temp5 = st.pop();
                st.push(temp4 + temp5);
                break;

            } // end of switch

        } // end of for i

        for(int i=0; i<st.size(); i++){
            System.out.println(st.pop());
        }



    }

}
