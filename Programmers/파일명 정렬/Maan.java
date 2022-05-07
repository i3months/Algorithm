import java.util.*;

public class Maan{
    public static void main(String[] args){
        String[] arr12 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        
        Solution sol = new Solution();

        String zz[] = sol.solution(arr12);

        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzz");

        for(int i=0; i<zz.length; i++){
            System.out.println(zz[i]);
        }        

        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzz");
        
        
    }
}

class Solution {
    public String[] solution(String[] files) {

        String[] answer = new String[files.length];
        
        File[] arr = new File[files.length];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = new File(files[i], i);
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<files.length; i++){
            answer[i] = arr[i].name; 
        }        
        
        
        return answer;
    }
}

class File implements Comparable<File>{
    String name;
    int sequence;
    
    File(String a, int b){
        name = a;
        sequence = b;
    }
    
    @Override
    public int compareTo(File o2){
        String head1 = "";
        String head2 = "";
        
        int start1 = 0;
        int start2 = 0;
         
        
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i) >= '0' && name.charAt(i) <= '9'){
                start1 = i;
                break;
            }
            head1 = head1 + name.charAt(i);
        }
        
        for(int i=0; i<o2.name.length(); i++){
            if(o2.name.charAt(i) >= '0' && o2.name.charAt(i) <= '9'){
                start2 = i;
                break;
            }
            head2 = head2 + o2.name.charAt(i);
        }
        
        String num1_s = "";
        String num2_s = "";
        
        for(int i = start1; i<name.length(); i++){
            if(!(name.charAt(i) >= '0' && name.charAt(i) <= '9')){
                break;
            }
            num1_s = num1_s + name.charAt(i);
        }
        
        for(int i = start2; i<o2.name.length(); i++){
            if(!(o2.name.charAt(i) >= '0' && o2.name.charAt(i) <= '9')){
                break;
            }
            num2_s = num2_s + o2.name.charAt(i);
        }
        
        int num1 = Integer.parseInt(num1_s);
        int num2 = Integer.parseInt(num2_s);

        head1 = head1.toUpperCase();
        head2 = head2.toUpperCase();
        
        int return_val = head1.compareTo(head2);

        // System.out.println(return_val);

        if(return_val == 0){            
            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return -1;
            }else{
                if(sequence > o2.sequence){
                    return 1;
                }else{
                    return -1;
                }
            }
        }else{
            return return_val;
        }
        
        
        
    }
    
}