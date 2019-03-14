package com.example.service;

import android.app.IntentService;
import android.content.Intent;

public class MyService extends IntentService {

    public MyService() {
        super(MyService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        sendMyBroadCast();
    }

    private void sendMyBroadCast() {
        try {
            Intent broadCastIntent = new Intent();
            broadCastIntent.setAction(MainActivity.BROADCAST_ACTION);

            sendBroadcast(broadCastIntent);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}