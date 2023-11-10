package com.example.calculator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SimpleCalculator extends AppCompatActivity {

    private Double CalculaitonResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalculaitonResult = 0.0D;

        setContentView(R.layout.activity_simple_calculator);

        if (savedInstanceState != null) {

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("saving data");
        // Additional info about calculator state in case of flipping phone
        outState.putString("context", "simple_calc");
    }
}
