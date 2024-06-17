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

public class CubeCalculator extends AppCompatActivity {

    EditText cubeLength;
    TextView cubeVolume;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube_calculator2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cubeLength = findViewById(R.id.lengthEditText);
        cubeVolume = findViewById(R.id.textView3);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> {
            double length= Double.parseDouble(cubeLength.getText().toString());
            double volume = length * length * length;
            cubeVolume.setText(Math.round(volume) + " m^3");
        });
    }
}