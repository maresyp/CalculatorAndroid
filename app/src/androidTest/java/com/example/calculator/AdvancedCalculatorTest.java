package com.example.calculator;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculator.activities.AdvancedCalculator;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AdvancedCalculatorTest {

    @Rule
    public ActivityScenarioRule<AdvancedCalculator> activityRule = new ActivityScenarioRule<>(AdvancedCalculator.class);

    @Test
    public void testCosCalculation() {
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.cosButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }

    @Test
    public void testCosCalculationWithMinus() {
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.cosButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("9")));
    }

    @Test
    public void testSinCalculation() {
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.sinButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }

    @Test
    public void testXSquaredWithPlusCalculation() {
        // Set up
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.xSquaredButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Verify
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("30")));
    }

    @Test
    public void testXSquaredWithDoublePlusCalculation() {
        // Set up
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.xSquaredButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Verify
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("35")));
    }

    @Test
    public void testXSquaredWithMultipleEqual() {
        // Set up
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.xSquaredButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Verify
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("390625")));
    }

    @Test
    public void testTanCalculation() {
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.tanButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }

    @Test
    public void testTanCalculationWithMinus() {
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.tanButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("10")));
    }

    @Test
    public void testLogCalculation() {
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.logButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("1")));
    }

    @Test
    public void testLogCalculationWithMinus() {
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.logButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("8")));
    }

    @Test
    public void testSqrtCalculation() {
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.sqrtButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("2")));
    }

    @Test
    public void testSqrtCalculationWithMinus() {
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.sqrtButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("2")));
    }

    @Test
    public void testSqrtCalculationWithDoubleMinus() {
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.sqrtButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("2")));

        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("2")));

        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }

    @Test
    public void testSqrtCalculationWithDoubleEquals() {
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.sqrtButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("2")));

        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("2")));

        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }

    @Test
    public void testXtoYCalculation() {
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.xToYButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("16")));
    }

    @Test
    public void testXtoYCalculationWithMinus() {
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.xToYButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("16")));
    }

    @Test
    public void testXtoYCalculationWithDoubleEquals() {
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.xToYButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("256")));
    }

    @Test
    public void testXtoYCalculationWithDoubleOperation() {
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.xToYButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.xToYButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("16")));
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("256")));
    }

    @Test
    public void testXtoYCalculationWithDoubleEqualsAndMinus() {
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.xToYButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("256")));
    }

    @Test
    public void testLnCalculation() {
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.lnButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }

    @Test
    public void testLnCalculationWithDecimal() {
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.decimal)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button7)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button8)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button3)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.lnButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("1,000006685")));
    }


}