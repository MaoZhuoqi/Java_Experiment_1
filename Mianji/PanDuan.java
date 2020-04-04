package Mianji;

public class PanDuan {
    public boolean panduan;
    public void panDuan(double a, double b, double c){
        if (a + b <= c | a + c <= b | b + c <= a) {
            System.out.print("尺寸错误，两边之和须大于第三边");
            panduan =  false;
        }
        else
            panduan = true;
    }
}
