package com.example.myvolumecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView myGridView;
    ArrayList<ShapeClass> ShapesList;
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        myGridView=findViewById(R.id.MyGridView);
        ShapeClass s1=new ShapeClass("Sphere",R.drawable.sphere);
        ShapeClass s2=new ShapeClass("Cylinder",R.drawable.cylinder);
        ShapeClass s3=new ShapeClass("Cube",R.drawable.cube);
        ShapeClass s4=new ShapeClass("Cuboid",R.drawable.cuboid);
        ShapesList=new ArrayList<>();
        ShapesList.add(s1);
        ShapesList.add(s2);
        ShapesList.add(s3);
        ShapesList.add(s4);
        adapter=new MyCustomAdapter(getApplicationContext(),ShapesList);
        myGridView.setAdapter(adapter);

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(getApplicationContext(), SphereCalculator.class);
                startActivity(i);
            }
        });
    }
}