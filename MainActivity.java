package com.example.april;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gradledemo.java.ConstantsFlavors;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";
    private static final String DEMO_VERSION = "demo";
    private static final String FULL_VERSION = "full";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ConstantsFlavors.type == ConstantsFlavors.Type.DEMO) {
            Log.i(TAG, DEMO_VERSION);
        } else {
            Log.i(TAG, FULL_VERSION);
        }
    }
}
