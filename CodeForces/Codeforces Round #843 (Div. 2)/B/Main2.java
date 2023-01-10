import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main2 {    
    static StringBuilder sb = new StringBuilder(); 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                              

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {            
            String str = br.readLine();

            int count = 0;
            int idx1 = 0;
            int idx2 = 0;

            char start = str.charAt(0);

            if(start == 'a') {
                
                for(int i=1; i<str.length(); i++) {
                    if(str.charAt(i-1) != str.charAt(i)) {
                        count++;
                        
                        if(idx1 == 0) {
                            idx1 = i;
                            continue;
                        }
                        
                        if(idx1 !=0 && idx2 == 0) {
                            idx2 = i;
                        }
                    }
                }                

                if(count == 0) {
                    sb.append("a ");
                    sb.append("a ");
                    for(int i=2; i<str.length(); i++) {
                        sb.append("a");
                    }
                    sb.append("\n");

                } else if(count == 1) {
                    String a = str.substring(0, idx1);
                    String b = str.substring(idx1, str.length());

                    int len1 = a.length();
                    int len2 = b.length();

                    if (len1 > len2) {                        
                        for(int i=0; i<len1-1; i++) {
                            sb.append("a");                            
                        } 
                        sb.append(" a ");
                        sb.append(b + "\n");                                                
                    } else {
                        sb.append(a + " ");                                                
                        for(int i=0; i<len2-1; i++) {
                            sb.append("b");                            
                        }
                        sb.append(" b\n");                        
                    }
                } else {
                    String a = str.substring(0, idx1);
                    String b = str.substring(idx1, idx2);
                    String c = str.substring(idx2, str.length());

                    sb.append(a + " " + b + " " + c + "\n");
                    
                }

            } else {

                for(int i=1; i<str.length(); i++) {
                    if(str.charAt(i-1) != str.charAt(i)) {
                        count++;
                        
                        if(idx1 == 0) {
                            idx1 = i;
                            continue;
                        }
                        
                        if(idx1 !=0 && idx2 == 0) {
                            idx2 = i;
                        }
                    }
                }

                if(count == 0) {
                    sb.append("b ");                                        
                    for(int i=2; i<str.length(); i++) {
                        sb.append("b");
                    }
                    sb.append(" b\n");                    
                } else if(count == 1) {
                    String a = str.substring(0, idx1);
                    String b = str.substring(idx1, str.length());                    

                    int len1 = a.length();
                    int len2 = b.length();

                    if (len1 > len2) {
                        sb.append("b ");                                                
                        for(int i=0; i<len1-1; i++) {
                            sb.append("b");                            
                        }                  
                        sb.append(" " + b + "\n");                                                      
                    } else {
                        for(int i=0; i<len1; i++) {
                            sb.append("b");
                        }
                        sb.append(" a ");                        
                        for(int i=0; i<len2-1; i++) {
                            sb.append("a");
                        }
                        sb.append("\n");                        
                    }
                } else {
                    String a = str.substring(0, idx1);
                    String b = str.substring(idx1, idx2);
                    String c = str.substring(idx2, str.length());

                    sb.append(a + " " + b + " " + c + "\n");
                }
            }

        }
        
        System.out.println(sb);
    }
}
