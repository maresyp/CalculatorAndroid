package com.example.calculator;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculator.activities.AdvancedCalculator;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AdvancedCalculatorRunSimpleTests extends SimpleCalculatorTest {

    @Rule
    public ActivityScenarioRule<AdvancedCalculator> activityRule = new ActivityScenarioRule<>(AdvancedCalculator.class);
}