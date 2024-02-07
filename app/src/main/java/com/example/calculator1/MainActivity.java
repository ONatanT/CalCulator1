package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView display;
//    private Button buttonAC = findViewById(R.id.buttonAC);
    private String firstOperand = "";
    private String secondOperand = "";
    private String currentOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        display = findViewById((R.id.textViewSolution));
    }
    public void onNumberClick(View view){
        Button button = (Button) view;
        String currentDisplay = display.getText().toString();
        Button buttonAC = findViewById(R.id.buttonAC);
        buttonAC.setText("C");
        display.setText(currentDisplay + button.getText().toString());
    }
    public void onOperatorClick(View view){
        Button button =(Button) view;
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonSubtract.setText("±");
        firstOperand = display.getText().toString();
        currentOperator = button.getText().toString();
        display.setText("");
    }

    public void onDotClick(View view){
        String currentDisplay = display.getText().toString();
        if(!currentDisplay.contains(".")){
            display.setText(currentDisplay + ".");
        }
    }

    public void onSubtractClick(View view){
        Button buttonSubtract = (Button) view;
        buttonSubtract = findViewById(R.id.buttonSubtract);
//        String currentDisplay = display.getText().toString();
//        if (buttonSubtract.getText().toString().equals("±")) {
//            buttonSubtract.setText("-");
//            display.setText(buttonSubtract + currentDisplay);
//        }

        double num = Double.parseDouble(display.getText().toString());


        String currentDisplay = display.getText().toString();
        switch (buttonSubtract.getText().toString()){
            case "±":
                buttonSubtract.setText("+");
//                display.setText(buttonSubtract.getText().toString() + currentDisplay);
                if(secondOperand.isEmpty() && firstOperand.isEmpty()){
                    display.setText(num * -1 + currentDisplay);
                }else if (secondOperand.isEmpty() && !firstOperand.isEmpty()){
                    display.setText(buttonSubtract.getText().toString() +firstOperand);
                }
                else{
                    display.setText(buttonSubtract.getText().toString() +secondOperand);
                }
                buttonSubtract.setText("+");
                break;
            case "+":
                display.setText(buttonSubtract + currentDisplay);
                if(secondOperand.isEmpty() && firstOperand.isEmpty()){
                    display.setText(buttonSubtract.getText().toString()  + currentDisplay);
                }else if (secondOperand.isEmpty() && !firstOperand.isEmpty()){
                    display.setText(buttonSubtract.getText().toString() +firstOperand);
                }
                else{
                    display.setText(buttonSubtract.getText().toString() +secondOperand);
                }
                buttonSubtract.setText("-");
                break;
            case "-":
                if(secondOperand.isEmpty() && firstOperand.isEmpty()){
                    display.setText(buttonSubtract.getText().toString()  + currentDisplay);
                }else if (secondOperand.isEmpty() && !firstOperand.isEmpty()){
                    display.setText(buttonSubtract.getText().toString() +firstOperand);
                }
                else{
                    display.setText(buttonSubtract.getText().toString() +secondOperand);
                }
                buttonSubtract.setText("+");
                break;
        }
//        String currentDisplay = display.getText().toString();
//        if(secondOperand.isEmpty() && firstOperand.isEmpty()){
//            display.setText("-" + currentDisplay);
//            return;
//        }else if (secondOperand.isEmpty() && !firstOperand.isEmpty()){
//            display.setText(""+firstOperand);
//            return;
//        }
//        else{
//            display.setText(""+secondOperand);
//            return;
//        }
    }

    public void onAcClick(View view){
        Button buttonAC = (Button) view;
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonSubtract.setText("±");
        if (buttonAC.getText().toString().equals("C")){
            display.setText("");
            buttonAC.setText("AC");
        }
        display.setText("");
        firstOperand = "";
        secondOperand = "";
        currentOperator = "";
    }

    public void onEqualClick(View view){
        secondOperand = display.getText().toString();
        double result = calculateResult();
        display.setText(String.valueOf(result));
    }

    private double calculateResult(){
        System.out.println("FirstOperand " + firstOperand);
        System.out.println("SecondOperand " + secondOperand);

        double num1 = Double.parseDouble(firstOperand);
        double num2 = Double.parseDouble(secondOperand);
        System.out.println("num2: " + num2);
        double result = 0;
        try {
            switch (currentOperator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "x":
                    result = num1 * num2;
                    break;
                case "/": {
                    if (num2 == 0){
                        throw new ArithmeticException("Cannot divide by zero");
                    } else {
                        result = num1 / num2;
                        break;
                    }
                }
                case "%":
                    result = num1 % num2;
                    break;
            }
            return result;
        }
        catch (ArithmeticException e){
            display.setText(e.getMessage());
        }
         return 0;
    }
}

