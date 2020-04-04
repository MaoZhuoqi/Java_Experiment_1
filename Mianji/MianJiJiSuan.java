package Mianji;

public class MianJiJiSuan {
    private double s;
    private double mianji;
    public void showMianJi(double a, double b, double c)
    {
        s=(a+b+c)/2;
        mianji = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.print("面积为："+mianji);
    }

}
