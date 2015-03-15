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

    private Button buttonAdd;
    private Button buttonSubtract;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonEquals;
    private Button buttonAC;
    private Button buttonDot;
    Calculator calc;


    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        calc = new Calculator();

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
