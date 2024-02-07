package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String firstOperand = "";
    private String secondOperand = "";
    private String currentOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        display = findViewById((R.id.textViewSolution));
    }

    public void onDotClick(View view){
        String currentDisplay = display.getText().toString();
        if(!currentDisplay.contains(".")){
            display.setText(currentDisplay + ".");
        }
    }

    public void onSubtractClick(View view){
        String currentDisplay = display.getText().toString();
        if(currentDisplay.isEmpty()){
            display.setText("-");
        }
    }

    public void onNumberClick(View view){
        Button button = (Button) view;
        String currentDisplay = display.getText().toString();
        display.setText(currentDisplay + button.getText().toString());
    }

    public void onOperatorClick(View view){
        Button button =(Button) view;
        firstOperand = display.getText().toString();
        currentOperator = button.getText().toString();
        display.setText("");
    }

    public void onAcClick(View view){
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
        double num1 = Double.parseDouble(firstOperand);
        double num2 = Double.parseDouble(secondOperand);
        double result = 0;
        switch (currentOperator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "%":
                result = num1 % num2;
                break;
        }
        return result;
    }
}

