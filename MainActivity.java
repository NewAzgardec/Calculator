package com.example.xiaomi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultView;
    EditText firstNum;
    EditText secondNum;
    Button sumButton;
    Button minButton;
    Button mulButton;
    Button divButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getId();

        sumButton.setOnClickListener(viewOnClick);
        minButton.setOnClickListener(viewOnClick);
        mulButton.setOnClickListener(viewOnClick);
        divButton.setOnClickListener(viewOnClick);

    }

    public void getId() {
        firstNum = findViewById(R.id.firstNumber);
        secondNum = findViewById(R.id.secondNumber);
        resultView = findViewById(R.id.result);
        sumButton = findViewById(R.id.plus);
        minButton = findViewById(R.id.minus);
        mulButton = findViewById(R.id.multiply);
        divButton = findViewById(R.id.divide);
    }

    protected View.OnClickListener viewOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            float num1;
            float num2;
            float res = 0;

            if (TextUtils.isEmpty(firstNum.getText().toString()) || TextUtils.isEmpty(secondNum.getText().toString())) {
                return;
            }

            num1 = Float.parseFloat(firstNum.getText().toString());
            num2 = Float.parseFloat(secondNum.getText().toString());

            switch (view.getId()) {
                case R.id.plus:
                    res = num1 + num2;
                    break;
                case R.id.minus:
                    res = num1 - num2;
                    break;
                case R.id.divide:
                    res = num1 / num2;
                    break;
                case R.id.multiply:
                    res = num1 * num2;
                    break;
                default:
                    break;

            }
            resultView.setText(Float.toString(res));
        }
    };
}