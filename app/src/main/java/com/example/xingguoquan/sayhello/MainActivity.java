package com.example.xingguoquan.sayhello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.RecognizerListener;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=58dc5dc3");

        super.onCreate(savedInstanceState);
        System.out.println("1111111111on creating");
        setContentView(R.layout.activity_main);

        System.out.print("hello again");

    }

    public void startMyService(View view) {

//        findViewById(R.id.recording).setOnClickListener(mRecoListener);
        startService(new Intent(getBaseContext(), MyService.class));

        System.out.println("view IIIIIID:" + view.getId());


    }

    // Method to stop the service
    public void stopMyService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }


}
