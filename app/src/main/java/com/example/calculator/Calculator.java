package com.example.calculator;

import android.app.Application;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

public class Calculator extends Application implements ViewModelStoreOwner {
    private final ViewModelStore viewModelStore = new ViewModelStore();

    @Override
    public ViewModelStore getViewModelStore() {
        return viewModelStore;
    }
}
