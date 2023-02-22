package com.example.myeventlistnerdemo.RollbackEvent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;

public class TestButton extends androidx.appcompat.widget.AppCompatButton {

    public static String TAG = "TestButton";

    public TestButton(Context context) {
        super(context);
    }

    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode,event);
        Log.i(TAG, "onKeyDown方法被调用");
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        super.onKeyUp(keyCode,event);
        Log.i(TAG,"onKeyUp方法被调用");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent: " + "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "onTouchEvent: " + "ACTION_UP");
        }
        Log.i(TAG,"onTouchEvent方法被调用");
        return true;  
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        super.onKeyLongPress(keyCode, event);
        Log.i(TAG, "onKeyLongPress: ");
        return true;
    }
}
