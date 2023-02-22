package com.example.myeventlistnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.myeventlistnerdemo.R;
import com.example.myeventlistnerdemo.RollbackEvent.MyButton;
import com.example.myeventlistnerdemo.RollbackEvent.TestButton;

public class EventActivity extends AppCompatActivity {

    private TestButton mBtnEve;
    private MyButton btnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEve = findViewById(R.id.btn_eve);
        btnMy = findViewById(R.id.btn_my);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("EventActivity", "-----onTouchEvent-----");
                break;
            default:
        }
        return false;
    }
}