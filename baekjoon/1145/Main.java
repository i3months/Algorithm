import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int SIZE = 5;
    
    int[] arr = new int[SIZE];
    int min = 100;
    
    for (int i = 0; i < SIZE; i++) {
      arr[i] = sc.nextInt();

      if (min > arr[i]) {
        min = arr[i];
      }
    }

    int cnt = 0;
    while (true) {  
      for (int i = 0; i < SIZE; i++) {
        if (min % arr[i] == 0) cnt++;
      }
      
      if (cnt >= 3) break;

      cnt = 0;
      min++;
    }

    System.out.println(min);
  }
}