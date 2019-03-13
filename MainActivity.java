package com.example.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String BROADCAST_ACTION = "com.06032019.demo";

    Button startServiceBt;
    TextView receiverTv;
    MyBroadCastReceiver myBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMembers();
        setListener();
        registerMyReceiver();
    }

    private void initializeMembers()
    {
        startServiceBt = findViewById(R.id.start_service);
        receiverTv = findViewById(R.id.receiver_textview);

        myBroadCastReceiver = new MyBroadCastReceiver();
    }

    private void setListener() {

        try
        {
            startServiceBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startMyService();
                }
            });
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    private void startMyService()
    {
        try
        {
            Intent myServiceIntent = new Intent(this, MyService.class);
            startService(myServiceIntent);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void registerMyReceiver() {

        try
        {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BROADCAST_ACTION);
            registerReceiver(myBroadCastReceiver, intentFilter);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    class MyBroadCastReceiver extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent) {

            try
            {
                if (receiverTv != null)
                {
                    receiverTv.setText("You did it!\nBroadcast Received.");
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(myBroadCastReceiver);
    }
}