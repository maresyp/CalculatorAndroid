package com.example.calculator.activities;

import android.os.Bundle;

import com.example.calculator.R;

public class AdvancedCalculator extends SimpleCalculator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calculator);

        resultTextView = findViewById(R.id.resultTextView);
    }
}
