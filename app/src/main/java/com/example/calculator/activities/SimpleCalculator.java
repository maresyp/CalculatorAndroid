package com.example.calculator.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.calculator.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;

public class SimpleCalculator extends AppCompatActivity {
    protected TextView resultTextView;
    protected Button lastOperationClicked;
    protected Double CalculationResult;
    protected Double firstOperand;
    protected Double secondOperand;
    protected boolean allowNewInput = false;
    protected Function<Double, Double> currentOperation = Math::sin;
    protected HashMap<String, Button> operationButtons;
    protected HashMap<String, Button> nonOperationButtons;
    protected final int MAX_LENGTH = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && (savedInstanceState.getBoolean("advancedCalculatorInstance"))) {
            setContentView(R.layout.activity_advanced_calculator);
        } else {
            setContentView(R.layout.activity_simple_calculator);
        }

        CalculationResult = 0.0D;
        firstOperand = 0.0D;
        secondOperand = 0.0D;

        resultTextView = findViewById(R.id.resultTextView);

        operationButtons = new HashMap<>();
        operationButtons.put("plus", (Button) findViewById(R.id.plus));
        operationButtons.put("minus", (Button) findViewById(R.id.minus));
        operationButtons.put("times", (Button) findViewById(R.id.times));
        operationButtons.put("division", (Button) findViewById(R.id.division));
        operationButtons.put("equals", (Button) findViewById(R.id.equals));
        operationButtons.put("percent", (Button) findViewById(R.id.percent));

        nonOperationButtons = new HashMap<>();
        nonOperationButtons.put("button0", (Button) findViewById(R.id.button0));
        nonOperationButtons.put("button1", (Button) findViewById(R.id.button1));
        nonOperationButtons.put("button2", (Button) findViewById(R.id.button2));
        nonOperationButtons.put("button3", (Button) findViewById(R.id.button3));
        nonOperationButtons.put("button4", (Button) findViewById(R.id.button4));
        nonOperationButtons.put("button5", (Button) findViewById(R.id.button5));
        nonOperationButtons.put("button6", (Button) findViewById(R.id.button6));
        nonOperationButtons.put("button7", (Button) findViewById(R.id.button7));
        nonOperationButtons.put("button8", (Button) findViewById(R.id.button8));
        nonOperationButtons.put("button9", (Button) findViewById(R.id.button9));

        // assert both hashmaps are null free
        assert operationButtons.values().stream().noneMatch(Objects::isNull);
        assert nonOperationButtons.values().stream().noneMatch(Objects::isNull);

    }

    public void updateResultTextView() {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator(',');
        // At least one digit before decimal separator and 9 digits after
        DecimalFormat df = new DecimalFormat("0.000000000", otherSymbols);

        // remove trailing zeros
        df.setMaximumFractionDigits(9);
        df.setMinimumFractionDigits(0);

        String formatted = df.format(CalculationResult);
        if (formatted.length() > this.MAX_LENGTH) {
            Toast toast = Toast.makeText(getApplicationContext(), "Result is too big", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        resultTextView.setText(formatted);
    }

    public void numberButtonHandler(View view) {
        String clicked_number = ((TextView) view).getText().toString();
        String current_on_display = resultTextView.getText().toString();

        try {
            if (current_on_display.contains(",")) {
                if (current_on_display.length() >= this.MAX_LENGTH + 1) {
                    throw new Exception();
                }
            } else if (current_on_display.length() == this.MAX_LENGTH) {
                throw new Exception();
            }
        } catch (Exception e ) {
            Toast toast = Toast.makeText(getApplicationContext(), "Number is too big", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (current_on_display.equals("0") || current_on_display.equals("-0")) {
            if (clicked_number.equals("0")) {
                return;
            }
            resultTextView.setText(clicked_number);
        } else {
            if (this.allowNewInput) {
                resultTextView.setText(clicked_number);
                this.allowNewInput = false;
                return;
            }
            resultTextView.setText(String.format(Locale.getDefault(), "%s", current_on_display + clicked_number));
        }

        // Change AC button appearance
        Button allClearButton = findViewById(R.id.allClear);
        allClearButton.setText("C");
    }

    public void decimalOnClick(View view) {
        String current_on_display = resultTextView.getText().toString();

        this.lastOperationClicked = (Button) view;
        if (current_on_display.contains(",")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Number already has decimal separator", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if (current_on_display.length() >= this.MAX_LENGTH - 1) {
            Toast toast = Toast.makeText(getApplicationContext(), "Number is too big to add decimal separator", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        resultTextView.setText(String.format(Locale.getDefault(), "%s,", current_on_display));
    }

    @SuppressLint("SetTextI18n")
    public void onAllClearClick(View view) {
        String state = ((Button) findViewById(R.id.allClear)).getText().toString();
        this.lastOperationClicked = (Button) view;

        if (state.equals("AC")) {
            this.firstOperand = 0.0D;
        } else {
            ((Button) view).setText("AC");
        }
        this.secondOperand = 0.0D;
        resultTextView.setText("0");
        CalculationResult = 0.0D;
        allowNewInput = false;
    }

    public void signOnClick(View view) {
        String current_on_display = resultTextView.getText().toString();

        this.lastOperationClicked = (Button) view;
        if (current_on_display.equals("0")) {
            return;
        }

        if (current_on_display.charAt(0) == '-') {
            resultTextView.setText(current_on_display.substring(1));
        } else {
            resultTextView.setText(String.format(Locale.getDefault(), "-%s", current_on_display));
        }
        secondOperand *= -1;
    }

    public void percentOnClick(View view) {
        String current_on_display = resultTextView.getText().toString().replace(",", ".");
        this.lastOperationClicked = (Button) view;

        if (current_on_display.equals("0") || current_on_display.equals("-0")) {
            return;
        }

        double current_on_display_double = Double.parseDouble(current_on_display);
        this.CalculationResult = (this.firstOperand * current_on_display_double) / 100.0D;

        this.updateResultTextView();
    }

    public void updateFirstOperand(boolean clearResult) {
        this.firstOperand = Double.parseDouble(resultTextView.getText().toString().replace(",", "."));
        if (clearResult) {
            resultTextView.setText("0");
        }
    }

    public void divisionOnClick(View view) {
        beforeOperationClick(view);
        this.currentOperation = (x) -> {
            if (secondOperand == 0.0D) {
                Toast toast = Toast.makeText(getApplicationContext(), "Division by zero", Toast.LENGTH_SHORT);
                toast.show();
                return 0.0D;
            }
            return x / secondOperand;
        };
    }

    public void timesOnClick(View view) {
        beforeOperationClick(view);
        this.currentOperation = (x) -> x * secondOperand;
    }

    public void minusOnClick(View view) {
        beforeOperationClick(view);
        this.currentOperation = (x) -> x - secondOperand;
    }

    public void plusOnClick(View view) {
        beforeOperationClick(view);
        this.currentOperation = (x) -> x + secondOperand;
    }

    public void equalsOnClick(View view) {
        if (view != null) {
            this.secondOperand = Double.parseDouble(resultTextView.getText().toString().replace(",", "."));
        } else {
            this.lastOperationClicked = operationButtons.get("equals");
        }

        this.CalculationResult = this.currentOperation.apply(this.firstOperand);
        updateResultTextView();
    }

    public boolean checkImplicitEquals(Button button) {
        return operationButtons.containsValue(this.lastOperationClicked);
    }

    public void beforeOperationClick(View view) {
        if(allowNewInput) {
            return;
        }
        boolean implicitEqualsUsed = this.checkImplicitEquals((Button) view);
        if (implicitEqualsUsed) {
            this.secondOperand = Double.parseDouble(resultTextView.getText().toString().replace(",", "."));
            this.allowNewInput = true;
            this.equalsOnClick(null);
        }
        this.updateFirstOperand(!implicitEqualsUsed);
        this.lastOperationClicked = (Button) view;
    }
}
