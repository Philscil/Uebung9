package p2;

public class P2_main {
    public static void main(String[] args) {
        int[] a = {0,-1,0};
        int[] b = {0,0,-1};
        int[] c = {0,0,-1};

        int[][] matrix = {a,b,c};

        displayMatrix(matrix);

        matrix = calculateNeighbours(matrix);

        displayMatrix(matrix);
    }

    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                System.out.print(" " + matrix[i][k] + " ");
            }

            System.out.println("");
        }
    }

    public static int[][] calculateNeighbours(int[][] matrix) {
        int[][] arr = new int[3][3];
    
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (matrix[i][k] == 0) {
                    arr[i][k] = findNeighbours(matrix, i, k);
                } else {
                    arr[i][k] = -1;
                }
            }
        } 

        return arr;
    }

    public static int findNeighbours(int[][] matrix, int x, int y) {
        int count = 0;

        for (int i = x -1; i < x + 2; i++) {
            if (i < 0 || i > 2) {
                continue;
            }

            for (int k = y - 1; k < y + 2; k++) {
                if (k < 0 || k > 2) {
                    continue;
                }

                if (matrix[i][k] == -1) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
