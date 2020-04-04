package Mianji;

import java.util.Scanner;

public class MianJi {
    public static void main (String[] args){
        //a,b,c为三边
        double a;
        double b;
        double c;
        MianJiJiSuan mianjijisuan = new MianJiJiSuan();
        PanDuan panduan = new PanDuan();
        Scanner scan = new Scanner(System.in);
        System.out.print("输入a=");
        a = scan.nextDouble();
        System.out.print("输入b=");
        b = scan.nextDouble();
        System.out.print("输入c=");
        c = scan.nextDouble();
        panduan.panDuan(a,b,c);
        if(panduan.panduan = true)
            mianjijisuan.showMianJi(a, b, c);
    }
}
