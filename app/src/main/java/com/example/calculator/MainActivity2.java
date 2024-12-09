package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button button2;
    private TextView  result;
    private EditText num1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        button2 = findViewById(R.id.button2);
        result = findViewById(R.id.result);
        num1 = findViewById(R.id.number1);

        button2.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        float num = 0;
        float res = 0;

        try {
            // Get the text from the EditText
            String numStr = num1.getText().toString();
            // Convert the text to a float
            num = Float.parseFloat(numStr);

        } catch (NumberFormatException e) {
            result.setText("Invalid input"); // More informative error message
            return; // Stop execution if there's an error
        }

        if (v.getId() == R.id.button2) {
            if (num < 0) { // Handle negative input
                result.setText("Cannot calculate sqrt of negative number");
            } else {
                res = (float) Math.sqrt(num);
                result.setText(String.valueOf(res));
            }
        }
    }
    public void Click(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}