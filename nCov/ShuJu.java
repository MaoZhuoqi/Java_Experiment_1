package nCov;

import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShuJu {
    public void nCov() {
        int jr[] = new int[600];
        int ys[] = new int[600];
        int zg[] = new int[600];
        int sw[] = new int[600];
        int zy[] = new int[600];
        String sf[] = new String[600];
        String cs[] = new String[600];
        int i = 1;

        String url="https://ncov.dxy.cn/ncovh5/view/pneumonia";         //丁香园的网站
        String result="";
        BufferedReader in=null;     //创建一个使用默认大小输入缓冲区的缓冲字符输入流
        try{
            URL realUrl=new URL(url);
            URLConnection connection=realUrl.openConnection();
            connection.connect();
            in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line=in.readLine())!=null){
                result+=line+"\n";
            }

        }catch(Exception e){
            System.out.println("发送GET请求出现异常"+e);
            e.printStackTrace();
        }
        finally{
            try
            {
                if(in!=null){
                    in.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        result=result.replace("\"","");

        Pattern ChinaCountry=Pattern.compile("provinceName(.*?)]");
        Matcher ChinaMatcher=ChinaCountry.matcher(result);
        ChinaMatcher.find();                            //此行的功能为为后面过滤掉非中国的地区
        System.out.println("\n\n以下为国内各省份城市疫情汇总:\n");

        while(ChinaMatcher.find()) {

            String ProvinceSituation = ChinaMatcher.group(0);


            Pattern Province = Pattern.compile("Name:(.*?)create");//使用正则表达式提取字符
            String ProvinceName = ProvinceSituation.substring(13, ProvinceSituation.indexOf(','));//省份名字
            Pattern CitySituation = Pattern.compile("cityName(.*?)}");
            Matcher CitySituationMatcher = CitySituation.matcher(ProvinceSituation);

            while (CitySituationMatcher.find()) {

                String CityCondition = CitySituationMatcher.group(0);

                String CityName = CityCondition.substring(9, CityCondition.indexOf(','));

                CityCondition = CityCondition.substring(CityCondition.indexOf(',') + 1);

                String TodayConfirmed = CityCondition.substring(22, CityCondition.indexOf(','));//今日确诊

                CityCondition = CityCondition.substring(CityCondition.indexOf(',') + 1);

                String TotallyConfirmed = CityCondition.substring(15, CityCondition.indexOf(','));//总共确诊

                CityCondition = CityCondition.substring(CityCondition.indexOf(',') + 1);

                String suspectedCount = CityCondition.substring(15, CityCondition.indexOf(','));//疑似病例

                CityCondition = CityCondition.substring(CityCondition.indexOf(',') + 1);

                String CuredCount = CityCondition.substring(11, CityCondition.indexOf(','));//治愈病例

                CityCondition = CityCondition.substring(CityCondition.indexOf(',') + 1);

                String deadCount = CityCondition.substring(10, CityCondition.indexOf(','));//死亡病例


                int intTodayConfirmed = Integer.parseInt(TodayConfirmed);
                int intTotallyConfirmed = Integer.parseInt(TotallyConfirmed);
                int intsuspectedCount = Integer.parseInt(suspectedCount);
                int intCuredCount = Integer.parseInt(CuredCount);
                int intdeadCount = Integer.parseInt(deadCount);
                sf[i] = ProvinceName;
                cs[i] = CityName;
                jr[i] = intTodayConfirmed;
                zg[i] = intTotallyConfirmed;
                ys[i] = intsuspectedCount;
                zy[i] = intCuredCount;
                sw[i] = intdeadCount;
                i += 1;
            }

        }

        int max1 = 599;
        int max2 = 599;
        int max3 = 599;
        int max4 = 599;
        int max5 = 599;
        for(int k = 1 ; k < jr.length ; k++) {
            if(zg[k]>zg[max1])
                max1 = k;
        }
        for(int k = 1 ; k < jr.length ; k++) {
            if(zg[k]>zg[max2]&zg[k]<zg[max1])
                max2 = k;
        }
        for(int k = 1 ; k < jr.length ; k++) {
            if(zg[k]>zg[max3]&zg[k]<zg[max2])
                max3 = k;
        }
        for(int k = 1 ; k < jr.length ; k++) {
            if(zg[k]>zg[max4]&zg[k]<zg[max3])
                max4 = k;
        }
        for(int k = 1 ; k < jr.length ; k++) {
            if(zg[k]>zg[max5]&zg[k]<zg[max4])
                max5 = k;
        }

        System.out.println("省份:"+sf[max1]+"\t 城市:"+cs[max1]+"\t 今日确诊:"+jr[max1]+"\t 总共确诊:" +zg[max1]+"\t 疑似病例:"+ys[max1]+"\t 治愈病列:"+zy[max1]+ "\t 死亡病例:"+sw[max1]);
        System.out.println("省份:"+sf[max2]+"\t 城市:"+cs[max2]+"\t 今日确诊:"+jr[max2]+"\t 总共确诊:" +zg[max2]+"\t 疑似病例:"+ys[max2]+"\t 治愈病列:"+zy[max2]+ "\t 死亡病例:"+sw[max2]);
        System.out.println("省份:"+sf[max3]+"\t 城市:"+cs[max3]+"\t 今日确诊:"+jr[max3]+"\t 总共确诊:" +zg[max3]+"\t 疑似病例:"+ys[max3]+"\t 治愈病列:"+zy[max3]+ "\t 死亡病例:"+sw[max3]);
        System.out.println("省份:"+sf[max4]+"\t 城市:"+cs[max4]+"\t 今日确诊:"+jr[max4]+"\t 总共确诊:" +zg[max4]+"\t 疑似病例:"+ys[max4]+"\t 治愈病列:"+zy[max4]+ "\t 死亡病例:"+sw[max4]);
        System.out.println("省份:"+sf[max5]+"\t 城市:"+cs[max5]+"\t 今日确诊:"+jr[max5]+"\t 总共确诊:" +zg[max5]+"\t 疑似病例:"+ys[max5]+"\t 治愈病列:"+zy[max5]+ "\t 死亡病例:"+sw[max5]);


    }
}
