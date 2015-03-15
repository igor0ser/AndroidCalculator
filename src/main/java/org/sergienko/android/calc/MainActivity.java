package org.sergienko.android.calc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private Calculator mCalc;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mCalc = new Calculator();

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        Button buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        Button buttonEquals = (Button) findViewById(R.id.buttonEquals);
        Button buttonAC = (Button) findViewById(R.id.buttonAC);
        Button buttonDot = (Button) findViewById(R.id.buttonDot);
        mResult = (TextView) findViewById(R.id.result);
        mResult.setText("0");

        OnClickListener listenerAdd = new OnClickListener(){
            public void onClick(View w){
                mCalc.execute('+');
                mResult.setText(mCalc.getDisplay());
            }
        };
        OnClickListener listenerSubtract = new OnClickListener(){
            public void onClick(View w){
                mCalc.execute('-');
               mResult.setText(mCalc.getDisplay());
            }
        };
        OnClickListener listenerMultiply = new OnClickListener(){
            public void onClick(View w){
                mCalc.execute('*');
                mResult.setText(mCalc.getDisplay());
            }
        };
        OnClickListener listenerDivide = new OnClickListener(){
            public void onClick(View w){
                mCalc.execute('/');
                mResult.setText(mCalc.getDisplay());
            }
        };
        OnClickListener listenerEquals = new OnClickListener(){
            public void onClick(View w){
                mCalc.buttonEquals();
                mResult.setText(mCalc.getDisplay());
            }
        };
        OnClickListener listenerAC = new OnClickListener(){
            public void onClick(View w){
                mCalc.AC();
                mResult.setText(mCalc.getDisplay());
            }
        };

        OnClickListener listenerDot= new OnClickListener(){

            public void onClick(View w){
                mCalc.addDot();
                mResult.setText(mCalc.getDisplay());
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
        mCalc.addDigit(button.getText().charAt(0));
        mResult.setText(mCalc.getDisplay());
    }
}
