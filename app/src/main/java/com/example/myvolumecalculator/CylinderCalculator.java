package com.example.myvolumecalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CylinderCalculator extends AppCompatActivity {

    EditText radiusEditText;
    EditText heightEditText;
    TextView resultTextView;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder_calculator2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radiusEditText = findViewById(R.id.radiusview);
        heightEditText = findViewById(R.id.heightview);
        resultTextView = findViewById(R.id.textView3);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> {
            double radius=Double.parseDouble(radiusEditText.getText().toString());
            double height=Double.parseDouble(heightEditText.getText().toString());
            double volume=Math.PI*radius*radius*height;
            resultTextView.setText(Math.round(volume)+" m^3");
        });
    }
}