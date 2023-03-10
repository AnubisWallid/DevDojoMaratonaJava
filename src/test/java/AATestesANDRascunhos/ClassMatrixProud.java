package AATestesANDRascunhos;

public class ClassMatrixProud {
    public static void main(String[] args) {
        double[][] A = {{2, 5}, {4, 8}};
        double[][] B = {{3, 2}, {1, 5}};
        System.out.println(A.length);
        System.out.println(A[0].length);
        System.out.println("A = \n" + toString(A));
        System.out.println("B = \n" + toString(B));
        System.out.println("A * B = \n" + toString(mult(A, B)));

//        int soma1 = 1;
//        int soma2 = 1;
//        for (int i = 0; i < A.length; i++) {
//            System.out.print(A[i][i]);
//            soma1 *= A[i][i];
//        }
//        for (int i = A.length - 1; i >= 0; i--) {
//            System.out.print(A[i][(A.length - 1) - i]);
//            soma2 *= A[i][(A.length - 1) - i];
//        }
//        System.out.println();
//        System.out.println(soma1 - soma2);


    }

    private static String toString(double[][] matrix) {
        String aux = "";
        for (int i = 0; i < matrix.length; i++) {
            aux += "[" + matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                aux += "," + matrix[i][j];
            }
            aux += "]";
            if (i != matrix.length - 1) {
                aux += "\n";
            }
        }
        return aux;
    }

    //Calcula A * B. A e B precisam ser matrizes válidas.
    //A.colunas = B.linhas
    public static double[][] mult(double[][] A, double[][] B) {
        int n = A[0].length; //A.colunas = B.linha
        //Verfica se A.colunas = B.linha
        if (n != B.length) {
            throw new IllegalArgumentException("A.columns != B.linha");
        }
        int linha = A.length; //A.linha
        int colunas = B[0].length; //B.colunas
        double[][] C = new double[linha][colunas];
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < colunas; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}





