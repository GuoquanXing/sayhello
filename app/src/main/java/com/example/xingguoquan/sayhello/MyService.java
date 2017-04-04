package com.example.xingguoquan.sayhello;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private RecognizerListener mRecoListener;
    private MyInitListener myInitListener;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        //听写监听器
        mRecoListener= new RecognizerListener() {
            //听写结果回调接口(返回Json格式结果，用户可参见附录12.1)；
            //一般情况下会通过onResults接口多次返回结果，完整的识别内容是多次结果的累加；
            //关于解析Json的代码可参见MscDemo中JsonParser类；
            //isLast等于true时会话结束。
            public void onResult(RecognizerResult results, boolean isLast) {
                Log.d("Result:", results.getResultString());
            }

            //会话发生错误回调接口
            public void onError(SpeechError error) {
                error.getPlainDescription(true);//获取错误码描述
            }
            //开始录音
            public void onBeginOfSpeech () {
            }
            //音量值0~30

            public void onVolumeChanged(int volume) {
            }

            //结束录音
            public void onEndOfSpeech() {
            }

            //扩展用接口
            public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
            }

            @Override
            public void onVolumeChanged(int i, byte[] bytes) {

            }
        };

        //1.创建SpeechRecognizer对象，第二个参数：本地听写时传InitListener
        SpeechRecognizer mIat = SpeechRecognizer.createRecognizer(this, myInitListener);
        //2.设置听写参数，详见《科大讯飞MSC API手册(Android)》SpeechConstant类
        mIat.setParameter(SpeechConstant.DOMAIN, "iat");
        mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mIat.setParameter(SpeechConstant.ACCENT, "mandarin ");
        //3.开始听写
        mIat.startListening(mRecoListener);











        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
        }

        @Override
        public void onDestroy () {
            super.onDestroy();
            Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
        }
    }
