import java.util.*;
import java.io.*;

public class Main {	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, Integer> hm = new HashMap<>();

        String str = br.readLine();

        String tmp = "";
        
        for(int i=0; i<str.length(); i++){
            tmp = tmp + str.charAt(i);
            if(i % 3 == 2){
                if(!hm.containsKey(tmp)){
                    hm.put(tmp, 1);
                }else{
                    hm.put(tmp, hm.get(tmp) + 1);
                }
                tmp = "";
            }
        }

        int P = 13;
        int K = 13;
        int H = 13;
        int T = 13;

        ArrayList<String> list = new ArrayList<>(hm.keySet());

        boolean chk = false;

        for(int i=0; i<list.size(); i++){
            if(hm.get(list.get(i)) >= 2){
                chk = true;
                System.out.println("GRESKA");
                break;
            }else{
                if(list.get(i).charAt(0) == 'P'){
                    P--;
                }
                if(list.get(i).charAt(0) == 'K'){
                    K--;
                }
                if(list.get(i).charAt(0) == 'H'){
                    H--;
                }
                if(list.get(i).charAt(0) == 'T'){
                    T--;
                }

            }
        }

        

        if(!chk){
            System.out.println(P +" "+K+" "+H+" "+T);
        }
        

            
    }
        
}
