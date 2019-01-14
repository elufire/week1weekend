package com.example.rickb.week1weekend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    String lang;
    String operation;
    String numbersStringArray [];
    Boolean unary = false;
    TextView output;
    TextView input;
    List<Float> numbers = new ArrayList<>();
    String specialChars = "/!";
    String excla = "!";
    String digits = "0123456789";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.calculatorOutput);
        input = findViewById(R.id.calculatorInput);

    }
//onClick handles all the operations for the calculator and text view manipulations
    public void onClick(View view) {
        String temp;
        float tempVal;
        temp = input.getText().toString();
        //switch handles all the different cases for each of the five words
        switch (view.getId()) {

            case R.id.one:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("1");
                    break;
                } else
                    break;
            case R.id.two:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("2");
                    break;
                } else
                    break;
            case R.id.three:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("3");
                    break;
                } else
                    break;
            case R.id.four:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("4");
                    break;
                } else
                    break;
            case R.id.five:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("5");
                    break;
                } else
                    break;
            case R.id.six:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("6");
                    break;
                } else
                    break;
            case R.id.seven:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("7");
                    break;
                } else
                    break;
            case R.id.eight:

                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("8");
                    break;
                } else
                    break;
            case R.id.nine:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("9");
                    break;
                } else
                    break;

            case R.id.zero:
                temp = input.getText().toString();

                if (!temp.isEmpty() && specialChars.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("0");
                    break;
                } else
                    break;


            case R.id.euler:
                input.append(Float.valueOf((float) Math.E).toString());
                break;
            case R.id.pi:
                input.append(Float.valueOf((float) Math.PI).toString());
                break;

            case R.id.add:

                if (input.getText().toString().matches("~?[0-9]*\\.?[0-9]*")) {
                    operation = "+";
                    input.append("+");
                    break;
                } else {


                    break;
                }

            case R.id.subtract:
                if (input.getText().toString().matches("~?[0-9]*\\.?[0-9]*")) {
                    operation = "-";
                    input.append("-");
                    break;

                } else {
                    break;
                }

            case R.id.divide:
                if (input.getText().toString().matches("~?[0-9]*\\.?[0-9]*")) {
                    operation = "/";
                    input.append("/");
                    break;
                } else {

                    break;
                }

            case R.id.multiply:
                if (input.getText().toString().matches("~?[0-9]*\\.?[0-9]*")) {
                    operation = "*";
                    input.append("*");
                    break;
                } else {

                    break;
                }

            case R.id.power:
                if (input.getText().toString().matches("~?[0-9]*\\.?[0-9]*")) {
                    operation = "^";
                    input.append("^");
                    break;
                } else {

                    break;
                }
            case R.id.decimal:
                if (input.getText().toString().matches("~?[0-9]*|~?[0-9]*\\.?[0-9]*~?[+\\-/*^][0-9]*")) {
                    input.append(".");
                    break;
                } else {
                    break;
                }
                //equals is the engine of that really sets all the calculations in motion.
            case R.id.equals:
                lang = input.getText().toString();

                if (lang.isEmpty()) {
                    break;
                } else {
                    if (!unary) {
                        numbersStringArray = lang.split("[+/*\\-^]");


                        for (String str : numbersStringArray) {
                            str = str.replace("~", "-");
                            numbers.add(Float.parseFloat(str));
                        }
                        switch (operation) {
                            case "+":
                                output.setText(Float.toString(addition(numbers)));
                                break;
                            case "-":
                                output.setText(Float.toString(subtraction(numbers)));
                                break;
                            case "/":
                                output.setText(Float.toString(division(numbers)));
                                break;
                            case "*":
                                output.setText(Float.toString(multiplication(numbers)));
                                break;
                            case "^":
                                output.setText(Float.toString(toPower(numbers)));
                                break;
                        }
                        input.setText("");

                        numbersStringArray = new String[0];
                        numbers.clear();
                        break;
                    } else {
                        lang = lang.replace("ln", "");
                        lang = lang.replace("log", "");
                        lang = lang.replace("e^", "");
                        lang = lang.replace("sin", "");
                        lang = lang.replace("cos", "");
                        lang = lang.replace("tan", "");
                        lang = lang.replace("!", "");
                        lang = lang.replace("\u221A", "");
                        lang = lang.replace("\u215F\u2093", "");
                        lang = lang.replace("\u0025", "");
                        tempVal = Float.parseFloat(lang);
                        //if(lang.contains(+))


                        switch (operation) {
                            case "ln":
                                output.setText(Float.toString(natLog(tempVal)));
                                break;

                            case "log":
                                output.setText(Float.toString(logTen(tempVal)));
                                break;
                            case "sin":
                                output.setText(Float.toString(getSin(tempVal)));
                                break;

                            case "cos":
                                output.setText(Float.toString(getCos(tempVal)));
                                break;

                            case "tan":
                                output.setText(Float.toString(getTan(tempVal)));
                                break;

                            case "!":
                                output.setText(Float.toString(factorial(tempVal)));
                                break;

                            case "sqrt":
                                output.setText(Float.toString(squareRoot(tempVal)));
                                break;

                            case "recip":
                                output.setText(Float.toString(getReciprocal(tempVal)));
                                break;

                            case "perc":
                                output.setText(Float.toString(getPercentage(tempVal)));
                                break;

                        }

                        input.setText("");

                        numbersStringArray = new String[0];
                        numbers.clear();
                        break;

                    }
                }



            case R.id.clear:
                input.setText("");
                output.setText("");
                break;

            case R.id.backspace:
                lang = input.getText().toString();
                if (lang.isEmpty()) {
                    break;
                } else {

                    lang = lang.substring(0, lang.length() - 1);
                    input.setText(lang);
                    break;
                }
            case R.id.negative:
                temp = input.getText().toString();

                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("~");
                    break;
                } else
                    break;
            case R.id.naturalLog:
                temp = input.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    unary = true;
                    operation = "ln";
                    input.append("ln");
                    break;
                }
                    else
                        break;

            case R.id.logBaseTen:
                temp = input.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    unary = true;
                    operation = "log";
                    input.append("log");
                    break;
                }
                else
                    break;

            case R.id.eulerToPower:
                temp = input.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    unary = true;
                    operation = "e";
                    input.append("e^");
                    break;
                }
                else
                    break;

            case R.id.sin:
                temp = input.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    unary = true;
                    operation = "sin";
                    input.append("sin");
                    break;
                }
                else
                    break;

            case R.id.cos:
                temp = input.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    unary = true;
                    operation = "cos";
                    input.append("cos");
                    break;
                }
                else
                    break;

            case R.id.tan:
                temp = input.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    unary = true;
                    operation = "tan";
                    input.append("tan");
                    break;
                }
                else
                    break;

            case R.id.factorial:
                temp = input.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {

                    break;
                }
                else {
                    unary = true;
                    operation = "!";
                    input.append("!");
                    break;
                }


            case R.id.squareRoot:
                temp = input.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    unary = true;
                    operation = "sqrt";
                    input.append("\u221A");
                    break;
                }
                else
                    break;

            case R.id.reciprocal:
                temp = input.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    unary = true;
                    operation = "recip";
                    input.append("\u215F\u2093");
                    break;
                }
                else
                    break;

            case R.id.percentage:
                temp = input.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    break;
                }
                else{
                    unary = true;
                    operation = "perc";
                    input.append("\u0025");
                    break;
                }

            case R.id.memory:
                temp = output.getText().toString();
                if (temp.isEmpty() || digits.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    break;
                }
                else{
                    input.append(temp);
                    break;
                }

                

                }
        }
//methods the the onClick function will call when the equals button is pressed
    static float addition(List<Float> nums){
        return nums.get(0) + nums.get(1);
    }

    static float subtraction(List<Float> nums){
        return nums.get(0) - nums.get(1);
    }

    static float division(List<Float> nums){
        return nums.get(0) / nums.get(1);
    }

    static float multiplication(List<Float> nums){
        return nums.get(0) * nums.get(1);
    }

    static float toPower(List<Float> nums){
        return (float)Math.pow(nums.get(0), nums.get(1));
    }

    static float natLog(float temp){
        return (float)Math.log(temp);
    }

    static float logTen(float temp){
        return (float)Math.log10(temp);
    }

    static float getSin(float temp){
        return (float)Math.sin(temp);
    }

    static float getCos(float temp){
        return (float)Math.cos(temp);
    }

    static float getTan(float temp){
        return (float)Math.tan(temp);
    }

    static float eulerPower(float temp){
        return (float)Math.exp(temp);
    }

    static float factorial(float temp){
        if(temp == 0){
            return 1;
        }else if(temp != Math.ceil(temp)){
            return 0;
        }
        else
            return (temp *factorial(temp-1));
    }

    static float squareRoot(float temp){
        return (float)Math.sqrt(temp);
    }

    static float getReciprocal(float temp){
        return 1/temp;
    }

    static float getPercentage(float temp){
        return temp/100;
    }
}
