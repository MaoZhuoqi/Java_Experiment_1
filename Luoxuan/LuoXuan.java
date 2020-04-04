package Luoxuan;

import java.util.Scanner;

public class LuoXuan {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.print("输入a=");
        n = (int) scan.nextDouble();
        LuoXuanFangFa luoxuan = new LuoXuanFangFa();
        luoxuan.showLuoXuan(n);
    }
}
