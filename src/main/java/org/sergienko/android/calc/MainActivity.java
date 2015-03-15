package org.sergienko.android.calc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

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
    Button buttonAdd;
    Button buttonSubtract;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonEquals;
    Button buttonAC;
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
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonEquals = (Button) findViewById(R.id.buttonEquals);
        buttonAC = (Button) findViewById(R.id.buttonAC);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        result = (TextView) findViewById(R.id.result);
        result.setText("0");

        OnClickListener listenerAdd = new OnClickListener(){
            public void onClick(View w){
                calc.execute('+');
                result.setText(calc.display);
            }
        };
        OnClickListener listenerSubtract = new OnClickListener(){
            public void onClick(View w){
                calc.execute('-');
               result.setText(calc.display);
            }
        };
        OnClickListener listenerMultiply = new OnClickListener(){
            public void onClick(View w){
                calc.execute('*');
                result.setText(calc.display);
            }
        };
        OnClickListener listenerDivide = new OnClickListener(){
            public void onClick(View w){
                calc.execute('/');
                result.setText(calc.display);
            }
        };
        OnClickListener listenerEquals = new OnClickListener(){
            public void onClick(View w){
                calc.buttonEquals();
                result.setText(calc.display);
            }
        };
        OnClickListener listenerAC = new OnClickListener(){
            public void onClick(View w){
                calc.AC();
                result.setText(calc.display);
            }
        };

        OnClickListener listenerDot= new OnClickListener(){

            public void onClick(View w){
                calc.addDot();
                result.setText(calc.display);
            }
        };

        buttonAdd.setOnClickListener(listenerAdd);
        buttonSubtract.setOnClickListener(listenerSubtract);
        buttonDivide.setOnClickListener(listenerDivide);
        buttonMultiply.setOnClickListener(listenerMultiply);
        buttonEquals.setOnClickListener(listenerEquals);
        buttonAC.setOnClickListener(listenerAC);
        buttonDot.setOnClickListener(listenerDot);
    }

    public void onNumberKeyboardClick(View v) {
        Button button = (Button) v;
        calc.addDigit(button.getText().charAt(0));
        result.setText(calc.display);
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
