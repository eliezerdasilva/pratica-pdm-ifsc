package com.example.pratica_03_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private View Sorteio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaNovaActivity(v);
            }
        });

    }
    public void iniciaNovaActivity(View view){
        Intent i = new Intent(getApplicationContext(),Sorteio.class);
        startActivity(i);
    }
}