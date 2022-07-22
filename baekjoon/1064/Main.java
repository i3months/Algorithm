import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Pair[] arr = new Pair[3];
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double[] leng = new double[3];
        for(int i=0; i<3; i++){
            arr[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        if((arr[1].y-arr[0].y)*(arr[2].x-arr[1].x)==(arr[1].x-arr[0].x)*(arr[2].y-arr[1].y))
            System.out.println("-1");

        else {
            double one = Math.sqrt(Math.pow(arr[1].y-arr[0].y, 2)+Math.pow(arr[1].x-arr[0].x, 2));
            double two = Math.sqrt(Math.pow(arr[2].y-arr[0].y, 2)+Math.pow(arr[2].x-arr[0].x, 2));
            double three = Math.sqrt(Math.pow(arr[2].y-arr[1].y, 2)+Math.pow(arr[2].x-arr[1].x, 2));
            leng[0] = one + two;
            leng[1] = two + three;
            leng[2] = one + three;

            for(int i=0; i<3; i++) {
                if(min>leng[i])
                    min=leng[i];
                if(max<leng[i])
                    max=leng[i];
            }

            System.out.println(2*max-2*min);
        }
    }
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}