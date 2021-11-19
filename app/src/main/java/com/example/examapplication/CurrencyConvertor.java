package com.example.examapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyConvertor extends AppCompatActivity {

    private static final double BNG_EUR = 0.51129188;
    private static final double EUR_BGN = 1.95583;
    private static final String EMPTY_CURRENCY = "Enter value to convert!";
    public static final String RESULT = "Result: %.2f";
    private TextView resultTextView;
    private EditText valueEditText;
    private RadioGroup radioGroupFrom;
    private RadioGroup radioGroupTo;
    private RadioButton bgnButtonFrom;
    private RadioButton eurButtonFrom;
    private RadioButton eurButtonTo;
    private RadioButton bgnButtonTo;
    private Button convertButton;
    private int selectedButtonRadioGroupFrom;
    private int selectedButtonRadioGroupTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_convertor);

        resultTextView = findViewById(R.id.resultTextView);
        valueEditText = findViewById(R.id.valueEditText);
        radioGroupFrom = findViewById(R.id.radioGroupFrom);
        radioGroupTo = findViewById(R.id.radioGroupTo);
        bgnButtonFrom = findViewById(R.id.bgnButtonFrom);
        eurButtonFrom = findViewById(R.id.eurButtonFrom);
        eurButtonTo = findViewById(R.id.eurButtonTo);
        bgnButtonTo = findViewById(R.id.bgnButtonTo);
        convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(onClick);

    }

    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (valueEditText.getText().toString().isEmpty()) {
                Toast.makeText(CurrencyConvertor.this, EMPTY_CURRENCY, Toast.LENGTH_LONG).show();
                return;
            }

            double value = Double.parseDouble(valueEditText.getText().toString());

            double result = value;

            if (view.getId() == R.id.convertButton) {
                selectedButtonRadioGroupFrom = radioGroupFrom.getCheckedRadioButtonId();
                selectedButtonRadioGroupTo = radioGroupTo.getCheckedRadioButtonId();

                if (selectedButtonRadioGroupFrom == R.id.bgnButtonFrom &&
                        selectedButtonRadioGroupTo == R.id.eurButtonTo) {
                    result = value * BNG_EUR;
                }
                if (selectedButtonRadioGroupFrom == R.id.eurButtonFrom &&
                        selectedButtonRadioGroupTo == R.id.bgnButtonTo) {
                    result = value * EUR_BGN;
                }
            }

            resultTextView.setText(String.format(RESULT, result));
        }
    };


}