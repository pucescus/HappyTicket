package com.pucescus.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText input;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        button.setOnClickListener(listener);

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int unputInt = Integer.parseInt(input.getText().toString());
            if (isHappy(unputInt)) {
                output.setText("Счастливый");
            } else {
                output.setText("Несчастливый, следующий счастливый " + happyTicket(unputInt));
            }
        }
    };

    private boolean isHappy(int number) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= 3; i++) {
            sum1 = sum1 + number % 10;
            number = number / 10;
            sum2 = sum2 + number % 10;
            number = number / 10;
        }
        if (sum1 == sum2) {
            return true;
        } else {
            return false;
        }
    }

    private int happyTicket(int number) {

        while (!isHappy(number)) {
            number++;
        }
        return number;
    }
}