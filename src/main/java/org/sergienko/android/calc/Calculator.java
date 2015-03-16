package org.sergienko.android.calc;

import android.util.Log;

import java.text.NumberFormat;
import java.text.ParseException;

public class Calculator {
    private static final double MAX = 999999999;
    private final String mDot;
    private StringBuilder mStringBuilder;
    private NumberFormat mNumberFormat;
    private String mDisplay;
    private double mResult;
    private char mOperator = '+';
    private boolean mIsDotPresent = false;
    private double mBufferDouble;
    private boolean mEqualsWasPressed = false;
    private boolean mDigitWasPressed = true;

    public Calculator() {
        mStringBuilder = new StringBuilder(12);
        mStringBuilder.append('0');

        mNumberFormat = NumberFormat.getInstance();
        mNumberFormat.setMaximumFractionDigits(9);
        mNumberFormat.setGroupingUsed(false);
        mDot = mNumberFormat.format(new Double(0.1)).contains(",") ? "," : ".";

    }

    private boolean isLengthOk() {
        if (mIsDotPresent)
            return (mStringBuilder.length() <= 9);
        else
            return (mStringBuilder.length() <= 8);
    }

    public void addDigit(char c) {
        mDigitWasPressed = true;
        if (mEqualsWasPressed)
            mResult = 0;
        if (isLengthOk()) {
            if (mStringBuilder.toString().equals("0"))
                mStringBuilder.deleteCharAt(0);
            mStringBuilder.append(c);
            mDisplay = mStringBuilder.toString();
        }
    }

    public void addDot() {
        mDigitWasPressed = true;
        if (mEqualsWasPressed)
            mResult = 0;
        if ((!mIsDotPresent) && (isLengthOk())) {
            mStringBuilder.append(mDot);
            mIsDotPresent = true;
            mDisplay = mStringBuilder.toString();
        }
    }

    public void AC() {
        mDigitWasPressed = true;
        mStringBuilder.delete(0, mStringBuilder.length());
        mStringBuilder.append('0');
        mDisplay = mStringBuilder.toString();
        mResult = 0;
        mIsDotPresent = false;
        mEqualsWasPressed = false;
        mOperator = '+';

    }

    private void action() {
        if ((!mEqualsWasPressed)) {
            mBufferDouble = parseToDouble(mStringBuilder);
        }
        if (!mDigitWasPressed){
            mBufferDouble=mResult;
        }

        switch (mOperator) {
            case '+':
                mResult = mResult + mBufferDouble;
                break;
            case '-':
                mResult = mResult - mBufferDouble;
                break;
            case '/':
                mResult = mResult / mBufferDouble;
                break;
            case '*':
                mResult = mResult * mBufferDouble;
                break;
        }

        mDisplay = toDisplay(mResult);
        mStringBuilder.delete(0, mStringBuilder.length());
        mStringBuilder.append('0');
        mIsDotPresent = false;
    }

    public void execute(char c) {
        if (mDigitWasPressed){
            if (!mEqualsWasPressed) {
                action();
            }
            mDigitWasPressed=false;
            System.out.println(mDigitWasPressed);
        }
        mEqualsWasPressed = false;
        mOperator = c;
    }

    public void buttonEquals() {

        action();
        mEqualsWasPressed = true;
        mDigitWasPressed = true;
    }

    private String toDisplay(double d) {
        if (Double.isNaN(d)) {
            mResult = 0;
            return "error";
        }
        if ((d > MAX) || (d < -MAX)) {
            mResult = 0;
            return "error";
        } else {
            String s = mNumberFormat.format(d);
            if (s.length() > 9) {
                s = s.substring(0, 9);
                if (s.endsWith(","))
                    s = s.substring(0, 8);
            }
            return s;
        }
    }

    private double parseToDouble(StringBuilder s) {
        String result = s.toString();
        double d = 0;
        if (mIsDotPresent) {

            if (result.endsWith((String) mDot))
                result = result.substring(0, s.length() - 1);

            try {
                d = (double) mNumberFormat.parseObject(result);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } else {
            d = Double.parseDouble(s.toString());
        }
        return d;
    }

    public String getDisplay() {
        return mDisplay;
    }


}
