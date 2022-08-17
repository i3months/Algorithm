import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N, M;
    static int[][] map = new int[9][9];    

    static int ans;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        for(int i=0; i<9; i++){
            // StringTokenizer st= new StringTokenizer(br.readLine());
            String str = br.readLine();
            for(int j=0; j<9; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bt(0,0);

        

        
	}

    static void bt(int row, int column){
        
        if(column == 9){
            bt(row + 1, 0);
            return;
        }

        if(row == 9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        


        if(map[row][column] == 0){
            for(int i=1; i<10; i++){
                if(able(row, column, i)){
                    map[row][column] = i;
                    bt(row, column + 1);
                }
            }

            map[row][column] = 0;
            return;
        }
        bt(row, column + 1);


    }

    static boolean able(int r, int c, int val){
        for(int i=0; i<9; i++){
            if(map[r][i] == val){
                return false;
            }
        }


        for(int i=0; i<9; i++){
            if(map[i][c] == val){
                return false;
            }
        }


        int row3 = (r / 3) * 3;
        int col3 = (c / 3) * 3;

        for(int i=row3; i<row3 + 3; i++){
            for(int j=col3; j<col3 + 3; j++){
                if(map[i][j] == val){
                    return false;
                }
            }
        }

        return true;

    }
}