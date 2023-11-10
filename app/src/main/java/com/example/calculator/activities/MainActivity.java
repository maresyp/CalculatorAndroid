package com.example.calculator.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.calculator.Calculator;
import com.example.calculator.viewModels.CalcViewModel;
import com.example.calculator.enums.Context;
import com.example.calculator.R;

public class MainActivity extends AppCompatActivity {

    private CalcViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider((Calculator) getApplication()).get(CalcViewModel.class);
        MutableLiveData<Context> context = viewModel.getContext();

        if (context != null && context.getValue() != null) {
            if (context.getValue().equals(Context.SIMPLE_CALC)) {
                setContentView(R.layout.activity_simple_calculator);
            }
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void ok(View view) {
        viewModel.getContext().setValue(Context.SIMPLE_CALC);
        setContentView(R.layout.activity_simple_calculator);
    }
}