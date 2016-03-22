package com.ifpb20_03_16.toquenatela;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View onTouchView = findViewById(R.id.view);
        onTouchView.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final float x = event.getX();
        final float y = event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                Log.i("ON TOUCH EVENT", "DOWN + X: " + x + " Y " + y);
                Toast.makeText(this, "DOWN + X: " + x + " Y " + y, Toast.LENGTH_SHORT).show();
                break;

            case MotionEvent.ACTION_MOVE:
                Log.i("ON TOUCH EVENT", "MOVE + X: " + x + " Y " + y);
                Toast.makeText(this, "MOVE + X: " + x + " Y " + y, Toast.LENGTH_SHORT).show();
                break;

            case MotionEvent.ACTION_UP:
                Log.i("ON TOUCH EVENT", "UP + X: " + x + " Y " + y);
                Toast.makeText(this, "UP  + X: " + x + " Y " + y, Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        return super.onTouchEvent(event);
    }


}
