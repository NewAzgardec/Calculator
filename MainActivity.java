package com.example.xiaomi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView displayResultPlaceView;
    EditText displayFirstNumPlaceView;
    EditText displaySecondNumPlaceView;

    int num1 = Integer.parseInt(displayFirstNumPlaceView.getText().toString());
    int num2 = Integer.parseInt(displaySecondNumPlaceView.getText().toString());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayFirstNumPlaceView = findViewById(R.id.firstNumber);
        displaySecondNumPlaceView = findViewById(R.id.secondNumber);
        displayResultPlaceView= findViewById(R.id.result);

    }
    

    public void sumOfElements (View v){
        int res = num1 + num2;
        displayResultPlaceView.setText(Integer.toString(res));
    }

    public void minOfElements (View v){
        int res = num1 - num2;
        displayResultPlaceView.setText(Integer.toString(res));
    }

    public void mulOfElements (View v){
        int res = num1 * num2;
        displayResultPlaceView.setText(Integer.toString(res));
    }

    public void divOfElements (View v){
        int res = num1 / num2;
        displayResultPlaceView.setText(Integer.toString(res));
    }
}

