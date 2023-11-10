package com.example.calculator.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calculator.enums.Context;
import com.example.calculator.interfaces.Operation;

public class CalcViewModel extends ViewModel {
    private final  MutableLiveData<Context> context = new MutableLiveData<>();
    private final  MutableLiveData<Double> calculation_result = new MutableLiveData<>();
    private final  MutableLiveData<Double> current_on_display = new MutableLiveData<>();
    private final  MutableLiveData<Operation> current_operation = new MutableLiveData<>();

    public MutableLiveData<Context> getContext() {
        return context;
    }

    public MutableLiveData<Double> getCalculation_result() {
        return calculation_result;
    }

    public MutableLiveData<Double> getCurrent_on_display() {
        return current_on_display;
    }

    public MutableLiveData<Operation> getCurrent_operation() {
        return current_operation;
    }

}
