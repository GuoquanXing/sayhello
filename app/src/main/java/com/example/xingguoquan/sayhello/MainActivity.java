package com.example.xingguoquan.sayhello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SpeechConstant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SpeechUtility.createUtility(context, SpeechConstant.APPID +"=58dc5dc3");

        super.onCreate(savedInstanceState);
        System.out.println("1111111111on creating");
        setContentView(R.layout.activity_main);
    }
}
