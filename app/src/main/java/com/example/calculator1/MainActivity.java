package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result, input;
    private Button[] numberButtons;
    private Button buttonAC, buttonPlusMinus, buttonPrecent, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEqual;
    private int firstOperand = 0, secondOperand = 0;
    private String operation = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.textViewSolution);

        result = findViewById(R.id.textViewResult);

//        numberButtons = new Button[10];
//        for (int i = 0; i < numberButtons.length; i++) {
//            String buttonID = "button" + i;
//            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
//            numberButtons[i] = findViewById(resID);
//            numberButtons[i].setOnClickListener(v -> input.append(((Button) v).getText().toString()));
//        }

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        //System.out.println("Hey im Here"+result);
    }

    public void funcButton(View view) {
        String solutionText = input.getText().toString();
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = input.getText().toString();
//        buttonAC = findViewById(R.id.buttonAC);
//        buttonPlusMinus = findViewById(R.id.buttonPlusMinus);
//        buttonAC.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View v) {
//                buttonAC.setText("C");
//            }
//        });
//        buttonPlusMinus.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View v) {
//                if (solutionText.equals("-")){
//                    buttonPlusMinus.setText("+");
//                }
//                else{
//                buttonPlusMinus.setText("-");
//            }
//        }
//        });
//        if (buttonText.equals("C")) {
//            input.setText("");
//            result.setText("0");
//        }
//        if (!solutionText.equals("-")){
//            buttonPlusMinus.setText("+");
//        }
//        else if (solutionText.equals("-")){
//            buttonPlusMinus.setText("-");
//        }
        if (!solutionText.equals("0")){
            buttonAC.setText("C");
        }
        if (buttonText.equals("=")) {
            input.setText(result.getText());
            return;
        }
        if (buttonText.equals("+")) {
            firstOperand = Integer.parseInt(solutionText);
            System.out.println("num1: " + firstOperand);
            input.setText("");
        }
        if (buttonText.equals("C")) {
            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
            return;
        } else {
            dataToCalculate += buttonText;
        }

        input.setText(dataToCalculate);
        result.append("");
//        String str = getResult(dataToCalculate);
//        result.setText(str);
    }


//    String getResult(String data){
//        try {
//            Context context = Context.enter();
//            context.setOptimizationLevel(-1);
//            Scriptable scriptable = context.initStandardObjects();
//            String finalResult = context.evaluateString(scriptable, data, "javascript", 1, null).toString();
//            return finalResult;
//
//        }catch (Exception e){
//            return "Error";
//        }
//    }
    // 1. Get the number from the button and store it in a variable
    // 2. Display the number on the screen (TextView)
    // 3. Get the operator from the button and store it in a variable
    // 4. Get the second number from the button and store it in a variable
    // 5. Perform the operation
    // 6. Display the result on the screen (TextView)
}

