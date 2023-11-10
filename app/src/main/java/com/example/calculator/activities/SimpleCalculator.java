package com.example.calculator.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculator.Calculator;
import com.example.calculator.viewModels.CalcViewModel;
import com.example.calculator.enums.Context;
import com.example.calculator.R;

public class SimpleCalculator extends AppCompatActivity {
    private CalcViewModel viewModel;
    private Double CalculaitonResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider((Calculator) getApplication()).get(CalcViewModel.class);
        viewModel.getContext().setValue(Context.SIMPLE_CALC);

        System.out.println("ELO ELO");

        CalculaitonResult = 0.0D;

        setContentView(R.layout.activity_simple_calculator);

    }

    public void fiveOnClick(View view) {

    }
}
