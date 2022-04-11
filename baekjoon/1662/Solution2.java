import java.util.*;
import java.io.*;

public class Solution2 {
  public static String[] compressed;
  public static Stack<String> stack;

  public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      compressed = br.readLine().split("");
      stack = new Stack<>();
      calculateDecompressedLength();

      long result = getLength();
      bw.write(String.valueOf(result));
      bw.flush();

      br.close();
      bw.close();

  }
  public static void calculateDecompressedLength(){
      for(int index = 0; index<compressed.length; index++){
          String currentChar = compressed[index];

          if(!currentChar.equals(")")){
              stack.push(currentChar);
          }
          else{
              int count = 0;

              while(!stack.peek().equals("(")){
                  String popedChar = stack.pop();

                  //* 앞에 있는 수는 문자열일 아니라 길이
                  if (popedChar.equals("*")) {
                      count += Integer.parseInt(stack.pop());
                  } else {
                      ++count;
                  }
              }
              // 스택에서 ( 제거
              stack.pop();

              //압축문자 해제 K(Q) K* Q의 길이(count)
              int k = Integer.parseInt(stack.pop());
              count *=k;

              stack.push(String.valueOf(count));
              stack.push("*");
          }
      }
  }
  public static long getLength(){
      long length = 0;
      while(!stack.isEmpty()){
          String popedString = stack.pop();

          if(popedString.equals("*")){
              length += Integer.parseInt(stack.pop());
          }
          else{
              length += 1;
          }
      }

      return length;
  }
}