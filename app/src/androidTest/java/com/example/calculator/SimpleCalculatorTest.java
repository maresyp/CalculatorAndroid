package com.example.calculator;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculator.activities.SimpleCalculator;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SimpleCalculatorTest {

    @Rule
    public ActivityScenarioRule<SimpleCalculator> activityRule =
            new ActivityScenarioRule<>(SimpleCalculator.class);

    @Test
    public void testPlusCalculation() {
        // Click the 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the plus button
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());

        // Click the 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the result button
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Check that the result is correct
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("10")));
    }

    @Test
    public void testDoublePlusCalculation() {
        // Click the 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the plus button
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());

        // Click the 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the plus button
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());

        // Click the 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the result button
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Check that the result is correct
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("15")));
    }

    @Test
    public void testMinusOnClick() {
        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the minus button
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());

        // Click the number 2 button
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());

        // Click the equals button
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Check that the result text view displays "3"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("3")));
    }

    @Test
    public void testDivisionCalculation() {
        // Click the 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the division button
        Espresso.onView(ViewMatchers.withId(R.id.division)).perform(ViewActions.click());

        // Click the 2 button
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());

        // Click the result button
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Check that the result is correct
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("2,5")));
    }

    @Test
    public void testDoubleDivisionCalculation() {
        // Click the 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the division button
        Espresso.onView(ViewMatchers.withId(R.id.division)).perform(ViewActions.click());

        // Click the 2 button
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());

        // Click the division button
        Espresso.onView(ViewMatchers.withId(R.id.division)).perform(ViewActions.click());

        // Check that the result is correct
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("2,5")));

        // Click the 2 button
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());

        // Click the result button
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Check that the result is correct
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("1,25")));
    }

    @Test
    public void testNumberButtonHandler() {
        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Check that the result text view displays "5"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("5")));
    }

    @Test
    public void testDecimalOnClick() {
        // Click the decimal button
        Espresso.onView(ViewMatchers.withId(R.id.decimal)).perform(ViewActions.click());

        // Check that the result text view displays "0,"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("0,")));
    }

    @Test
    public void testOnAllClearClick() {
        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the AC button
        Espresso.onView(ViewMatchers.withId(R.id.allClear)).perform(ViewActions.click());

        // Check that the result text view displays "0"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }

    @Test
    public void testSignOnClick() {
        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the sign button
        Espresso.onView(ViewMatchers.withId(R.id.sign)).perform(ViewActions.click());

        // Check that the result text view displays "-5"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("-5")));
    }

    @Test
    public void testSignOnClickTwice() {
        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the sign button
        Espresso.onView(ViewMatchers.withId(R.id.sign)).perform(ViewActions.click());

        // Click the sign button
        Espresso.onView(ViewMatchers.withId(R.id.sign)).perform(ViewActions.click());

        // Check that the result text view displays "5"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("5")));
    }

    @Test
    public void testSignWithOngoingCalculation() {
        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the plus button
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());

        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the sign button
        Espresso.onView(ViewMatchers.withId(R.id.sign)).perform(ViewActions.click());

        // Click the equals button
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Check that the result text view displays "0"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }

    @Test
    public void testSignWithDoubleOngoingCalculation() {
        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the plus button
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());

        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the plus button
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());

        // Check that the result text view displays "10"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("10")));

        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the sign button
        Espresso.onView(ViewMatchers.withId(R.id.sign)).perform(ViewActions.click());

        // Click the equals button
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Check that the result text view displays "5"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("5")));
    }

    @Test
    public void testPercentOnClick() {
        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the percent button
        Espresso.onView(ViewMatchers.withId(R.id.percent)).perform(ViewActions.click());

        // Check that the result text view displays "0"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }

    @Test
    public void testPercentWithMinusOperation() {
        // Click the number 1 and 0 button
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());

        // Click the minus button
        Espresso.onView(ViewMatchers.withId(R.id.minus)).perform(ViewActions.click());

        // Click the number 1 and 0 button
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());

        // Click the percent button
        Espresso.onView(ViewMatchers.withId(R.id.percent)).perform(ViewActions.click());

        // Check that the result text view displays "1"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("1")));

        // Click the equals button
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Check that the result text view displays "9"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("9")));
    }

    @Test
    public void testTimesOnClick() {
        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the times button
        Espresso.onView(ViewMatchers.withId(R.id.times)).perform(ViewActions.click());

        // Click the number 2 button
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());

        // Click the equals button
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Check that the result text view displays "10"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("10")));
    }

    @Test
    public void testPlusOnClick() {
        // Click the number 5 button
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());

        // Click the plus button
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());

        // Click the number 2 button
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());

        // Click the equals button
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Check that the result text view displays "7"
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("7")));
    }
}