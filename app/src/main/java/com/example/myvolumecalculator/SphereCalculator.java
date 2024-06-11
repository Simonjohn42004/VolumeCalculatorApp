package com.example.myvolumecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Scanner;

public class SphereCalculator extends AppCompatActivity {

    EditText Radius;
    Button calculatebutton;
    TextView resulttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Radius=findViewById(R.id.editText);
        calculatebutton=findViewById(R.id.calculateButton);
        resulttext=findViewById(R.id.textView3);



        calculatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius=Radius.getText().toString();
                double newradius=Double.parseDouble(radius);
                double cal= (4*3.14*newradius*newradius*newradius)/3;
                resulttext.setText(Math.round(cal)+" m^3");
            }
        });


    }
}