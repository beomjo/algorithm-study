import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int column = Integer.parseInt(input[1]);
        int[][] a = new int[row][column];
        for (int i = 0; i < row; i++) {
            String st = br.readLine();
            for (int j = 0; j < column; j++) {
                a[i][j] = Character.getNumericValue(st.charAt(j));
            }
        }

        int result = 0;

        for (int i = 0; i < (1 << row * column); i++) {
            int sum = 0;
            for (int r = 0; r < row; r++) {
                int rowSum = 0;
                for (int c = 0; c < column; c++) {
                    int colIndex = r * column + c;
                    if ((i & (1 << colIndex)) == 0) {
                        rowSum = rowSum * 10 + a[r][c];
                    } else {
                        sum += rowSum;
                        rowSum = 0;
                    }
                }
                sum += rowSum;
            }

            for (int c = 0; c < column; c++) {
                int colSum = 0;
                for (int r = 0; r < row; r++) {
                    int rowIndex = c + r * column;
                    if ((i & (1 << rowIndex)) != 0) {
                        colSum = colSum * 10 + a[r][c];
                    } else {
                        sum += colSum;
                        colSum = 0;
                    }
                }
                sum += colSum;
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}