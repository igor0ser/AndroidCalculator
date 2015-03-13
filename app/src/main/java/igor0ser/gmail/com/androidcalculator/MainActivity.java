package igor0ser.gmail.com.androidcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonEquals;
    Button buttonAC;
    Button buttonSign;
    Button buttonPercent;
    Button buttonDot;
    Calculator calc;


    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        calc = new Calculator();


        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button7);
        button5 = (Button) findViewById(R.id.buttonAC);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button7);
        button9 = (Button) findViewById(R.id.button9);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonEquals = (Button) findViewById(R.id.buttonEquals);
        buttonAC = (Button) findViewById(R.id.buttonAC);
        buttonSign = (Button) findViewById(R.id.buttonSign);
        buttonPercent = (Button) findViewById(R.id.buttonPercent);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        result = (TextView) findViewById(R.id.result);
        result.setText("0");

        OnClickListener listener0 = new OnClickListener(){
            public void onClick(View w){
                calc.setResult(0);
                result.setText(calc.result);
            }
           };
        OnClickListener listener1 = new OnClickListener(){
            public void onClick(View w){
                calc.setResult(1);
                result.setText(calc.result);
            }
        };
        OnClickListener listener2 = new OnClickListener(){
            public void onClick(View w){
                calc.setResult(2);
                result.setText(calc.result);
            }
        };
        OnClickListener listener3 = new OnClickListener(){
            public void onClick(View w){
                calc.setResult(3);
                result.setText(calc.result);
            }
        };
        OnClickListener listener4 = new OnClickListener(){
            public void onClick(View w){
                calc.setResult(4);
                result.setText(calc.result);
            }
        };
        OnClickListener listener5 = new OnClickListener(){
            public void onClick(View w){
                calc.setResult(5);
                result.setText(calc.result);
            }
        };
        OnClickListener listener6 = new OnClickListener(){
            public void onClick(View w){
                calc.setResult(6);
                result.setText(calc.result);
            }
        };
        OnClickListener listener7 = new OnClickListener(){
            public void onClick(View w){
                calc.setResult(7);
                result.setText(calc.result);
            }
        };
        OnClickListener listener8 = new OnClickListener(){
            public void onClick(View w){
                calc.setResult(8);
                result.setText(calc.result);
            }
        };
        OnClickListener listener9 = new OnClickListener(){
            public void onClick(View w){
                calc.setResult(9);
                result.setText(calc.result);
            }
        };
        OnClickListener listenerPlus = new OnClickListener(){
            public void onClick(View w){
            }
        };
        OnClickListener listenerMinus = new OnClickListener(){
            public void onClick(View w){
            }
        };
        OnClickListener listenerMultiply = new OnClickListener(){
            public void onClick(View w){
            }
        };
        OnClickListener listenerDivide = new OnClickListener(){
            public void onClick(View w){
            }
        };
        OnClickListener listenerEquals = new OnClickListener(){
            public void onClick(View w){
            }
        };
        OnClickListener listenerAC = new OnClickListener(){
            public void onClick(View w){
                calc.AC();
                result.setText(calc.result);
            }
        };
        OnClickListener listenerSign= new OnClickListener(){
            public void onClick(View w){
            }
        };
        OnClickListener listenerPercent= new OnClickListener(){
            public void onClick(View w){
            }
        };
        OnClickListener listenerDot= new OnClickListener(){

            public void onClick(View w){
                calc.dot();
                result.setText(calc.result);
            }
        };

        button0.setOnClickListener(listener0);
        button1.setOnClickListener(listener1);
        button2.setOnClickListener(listener2);
        button3.setOnClickListener(listener3);
        button4.setOnClickListener(listener4);
        button5.setOnClickListener(listener5);
        button6.setOnClickListener(listener6);
        button7.setOnClickListener(listener7);
        button8.setOnClickListener(listener8);
        button9.setOnClickListener(listener9);
        buttonPlus.setOnClickListener(listenerPlus);
        buttonMinus.setOnClickListener(listenerMinus);
        buttonDivide.setOnClickListener(listenerDivide);
        buttonMultiply.setOnClickListener(listenerMultiply);
        buttonEquals.setOnClickListener(listenerEquals);
        buttonAC.setOnClickListener(listenerAC);
        buttonSign.setOnClickListener(listenerSign);
        buttonPercent.setOnClickListener(listenerPercent);
        buttonDot.setOnClickListener(listenerDot);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
