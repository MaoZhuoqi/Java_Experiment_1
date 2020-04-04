package Luoxuan;

public class LuoXuanFangFa {
    public void showLuoXuan(int n) {
        int sum = n * n;
        int wei = calwei(sum);
        int A[][] = new int[n][n];
        A[0][0] = 1;

        //算左上至右下的对角线的值
        for (int i = 0; i < n / 2; i++) {
            A[i + 1][i + 1] = A[i][i] + 4 * (n - 2 * i - 1);
        }

        //计算每行上面横向的值
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - i; j++) {
                A[i][j] = A[i][j - 1] + 1;
            }
        }


        //计算每列右边竖向的值
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - i - 1; j < i; j++) {
                A[j + 1][i] = A[j][i] + 1;
            }
        }


        //计算每行下面横向的值
        for (int i = n - 1; i > n / 2; i--) {
            for (int j = i; j > n - i - 1; j--) {
                A[i][j - 1] = A[i][j] + 1;
            }
        }

        //计算每列左边竖向的值
        for (int i = 0; i < n / 2; i++) {
            for (int j = n - 1 - i; j > i + 1; j--) {
                A[j - 1][i] = A[j][i] + 1;
            }
        }


        //处理输入的值为偶数的情况
        if (n % 2 == 0) {
            A[n / 2][n / 2 - 1] = sum;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = calwei(A[i][j]);
                for (int k = 0; k < wei - temp; k++) {
                    System.out.print(" ");
                }
                System.out.print(A[i][j] + " ");
            }
            for (int s = 0; s < wei - 1; s++) {
                System.out.println();
            }
        }
    }



    //为了将矩阵补齐，看起来好看一些
    public static int calwei(int num){
        int wei=1;
        if(num/10<1) return 1;
        if(num/100<1) return 2;
        if(num/1000<1) return 3;
        if(num/10000<1) return 4;
        if(num/100000<1) return 5;
        if(num/10000000<1) return 6;
        if(num/100000000<1) return 7;
        else return 0;

    }


}
