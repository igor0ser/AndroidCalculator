package igor0ser.gmail.com.androidcalculator;

/**
 * Created by Admin on 13.03.2015.
 */
public class Calculator {
    double res;
    double res1;
    char operator = '+';
    boolean isBeforeDot = true;
    String result;
    StringBuilder sb;
    int dec = 1;

    void setResult(int x){
        if (isBeforeDot)
        res1 = res1*10 + x;
        else {
        res1 = res1 + x/Math.pow(10,dec);
            dec++;}
        result = Double.toString(res1);
    }
    void AC(){
        res1=0;
        result = Double.toString(res1);
    }

    void dot(){
        if (isBeforeDot){
        isBeforeDot=false;
        result = result + ".";}
    }

    String result(){
        return Double.toString(res);
    }

}
