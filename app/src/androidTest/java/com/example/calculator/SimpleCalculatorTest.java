package com.example.calculator;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculator.activities.SimpleCalculator;

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
}