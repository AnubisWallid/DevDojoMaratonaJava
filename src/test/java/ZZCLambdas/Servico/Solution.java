package ZZCLambdas.Servico;

import java.util.Scanner;

class Solution{
    public static void main(String []argh){
//        Scanner in = new Scanner(System.in);
//        int t=in.nextInt();
        for(int i=0;i<2;i++){
            int a = 5;//in.nextInt();
            int b = 3;//in.nextInt();
            int n = 5;//in.nextInt();
            int soma = a;  //5
            for(int j =0;j<n;j++){
                int x = (int) Math.pow(2,(double)n);
                int y = (int) x * b;
                int z = soma + y;
                soma = z;  //5 + 2^0 * 3

                System.out.printf("%d ",soma);
            }
            System.out.println();
        }
//        in.close();
    }
}
