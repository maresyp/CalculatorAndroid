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
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());

        // Verify
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("390625")));
    }
}