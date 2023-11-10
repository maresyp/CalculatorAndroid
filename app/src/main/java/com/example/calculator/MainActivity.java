package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            String context = savedInstanceState.getString("context");
            if (context != null) {
                if (context.equals("simple_calc")) setContentView(R.layout.activity_simple_calculator);
                // TODO : add advanced calc
            }
        }
        setContentView(R.layout.activity_main);
    }

    public void ok(View view) {
        setContentView(R.layout.activity_simple_calculator);
    }
}