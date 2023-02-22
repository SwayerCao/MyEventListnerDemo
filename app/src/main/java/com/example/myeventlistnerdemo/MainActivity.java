package com.example.myeventlistnerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private Button bt_handler_send;

    private MyHandler handler;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };

    //弱引用
    private static class MyHandler extends Handler{

        private final WeakReference<MainActivity> weakReference;

        public MyHandler(WeakReference<MainActivity> weakReference) {
            this.weakReference = weakReference;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            MainActivity activity = weakReference.get();
            super.handleMessage(msg);
            if (null != activity) {
                Toast.makeText(activity,"handleMessage",Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new MyHandler(new WeakReference<MainActivity>(this));

        bt_handler_send = findViewById(R.id.btn_handler);
        bt_handler_send.setOnClickListener(v -> {
            new Thread(() -> {
                handler.sendEmptyMessage(0);
            }).start();
        });
        new Thread(() -> {
            Message message = Message.obtain();
            message.what = 1;
            mHandler.sendMessage(message);
        }).start();

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                mHandler = new Handler() {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        mHandler.getLooper().quit();
                        mHandler.getLooper().quitSafely();
                    }
                };
                Looper.loop();
            }
        };
        thread.start();

        mHandler.sendMessage(Message.obtain());
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}