package org.sergienko.android.calc;

import java.text.NumberFormat;
import java.text.ParseException;

public class Calculator {
    private StringBuilder sb;
    private NumberFormat nf;
    public String display;
    private double result;
    private char operator = '+';
    private boolean haveItDot = false;
    private static final double MAX = 999999999;
    private double d;
    private boolean flag = false;

    public Calculator() {
        sb = new StringBuilder(12);
        sb.append('0');

        nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(9);
        nf.setGroupingUsed(false);
    }

    private boolean isLengthOk() {
        if (haveItDot)
            return (sb.length() <= 9);
        else
            return (sb.length() <= 8);
    }

    public void addDigit(char c) {
        if (flag)
            result = 0;
        if (isLengthOk()) {
            if (sb.toString().equals("0"))
                sb.deleteCharAt(0);
            sb.append(c);
            display = sb.toString();
        }
    }

    public void addDot() {
        if (flag)
            result = 0;
        if ((!haveItDot) && (isLengthOk())) {
            sb.append('.');
            haveItDot = true;
            display = sb.toString();
        }
    }

    public void AC() {
        sb.delete(0, sb.length());
        sb.append('0');
        display = sb.toString();
        result = 0;
        haveItDot = false;
        flag = false;
        operator = '+';

    }

    private void action() {
        if (!flag) {
            d = parseToDouble(sb);
            // operator = '+';
        }

        switch (operator) {
            case '+':
                result = result + d;
                break;
            case '-':
                result = result - d;
                break;
            case '/':
                result = result / d;
                break;
            case '*':
                result = result * d;
                break;
        }

        display = toDisplay(result);
        sb.delete(0, sb.length());
        sb.append('0');
        haveItDot = false;
    }

    public void execute(char c) {
        if (!flag) {
            action();
        }
        flag = false;
        operator = c;
    }

    public void buttonEquals() {
        action();
        // operator = '+';
        flag = true;
    }

    private String toDisplay(double d) {

        if ((d > MAX) || (d < -MAX)) {
            result = 0;
            return "error";
        } else {
            String s = nf.format(d);
            if (s.length() > 9) {
                s = s.substring(0, 9);
                if (s.endsWith(","))
                    s = s.substring(0, 8);
            }
            return s;
        }
    }

    private double parseToDouble(StringBuilder s) {
        String s1 = s.toString();
        double d = 0;
        if (haveItDot) {
            if (s1.endsWith("."))
                s1 = s1.substring(0, s.length() - 1);

            try {
                d = (double) nf.parseObject(s1);
            } catch (ParseException e) {
                System.err.println("something goes wrong with parsing.");
            }

        } else {
            d = Double.parseDouble(s1);
        }
        return d;
    }

}
