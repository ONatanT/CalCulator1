package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result, solution;
    int num1;
    int num2;
    char ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solution = findViewById(R.id.textViewSolution);

        result = findViewById(R.id.textViewResult);
        //System.out.println("Hey im Here"+result);
    }

    public void funcButton(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solution.getText().toString();
        if (buttonText.equals("AC")) {
            solution.setText("");
            result.setText("0");
            return;
        }
        if (buttonText.equals("=")) {
            solution.setText(result.getText());
            return;
        }
        if (buttonText.equals("C")) {
            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
        } else {
            dataToCalculate += buttonText;
        }

        solution.setText(dataToCalculate);
        result.append("");
        //String str = getResult(dataToCalculate);

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
