package com.example.xingguoquan.sayhello;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> 6f6a3f34c407eeff22a4d6ad44ed4c797f48f735
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SpeechConstant;
<<<<<<< HEAD
import com.iflytek.cloud.RecognizerListener;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=58dc5dc3");
=======

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SpeechUtility.createUtility(context, SpeechConstant.APPID +"=58dc5dc3");
>>>>>>> 6f6a3f34c407eeff22a4d6ad44ed4c797f48f735

        super.onCreate(savedInstanceState);
        System.out.println("1111111111on creating");
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

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


=======
    }
>>>>>>> 6f6a3f34c407eeff22a4d6ad44ed4c797f48f735
}
