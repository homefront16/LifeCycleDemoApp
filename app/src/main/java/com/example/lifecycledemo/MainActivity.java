package com.example.lifecycledemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnClickMe;
    TextView tvCounter;
    int clicks = 0;


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("clickerValue", clicks);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        clicks = savedInstanceState.getInt("clickerValue");
        tvCounter = findViewById(R.id.tvCounter);

        tvCounter.setText(Integer.toString(clicks));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycleFilter", "The App is Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycleFilter", "The App is Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycleFilter", "The App is Destroyed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycleFilter", "The App is Paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycleFilter", "The App is Resumed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycleFilter", "The App is Restarted");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClickMe = findViewById(R.id.btnClicker);
        tvCounter = findViewById(R.id.tvCounter);

        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicks++;
                tvCounter.setText(Integer.toString(clicks));


            }
        });
    }
}