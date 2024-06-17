package com.example.myvolumecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CuboidCalculator extends AppCompatActivity {

    EditText length, width, height;
    TextView result;
    Button calculate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuboid_calculator2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        length = findViewById(R.id.lengthview);
        width = findViewById(R.id.breadthview);
        height = findViewById(R.id.heightview);
        result = findViewById(R.id.cuboidresultview);
        calculate = findViewById(R.id.calculateButton);

        calculate.setOnClickListener(v -> {
            double l = Double.parseDouble(length.getText().toString());
            double w = Double.parseDouble(width.getText().toString());
            double h = Double.parseDouble(height.getText().toString());
            double volume = l * w * h;

            result.setText(Math.round(volume)+" m^3");
        });

    }
}