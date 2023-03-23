package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conta = (Button) findViewById(R.id.bt_imc);
        EditText peso = findViewById(R.id.txtPeso);
        EditText altura = findViewById(R.id.txtAltura);
        conta.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewIMC.class);

                Bundle params = new Bundle();
                params.putString("peso",peso.getText().toString());
                params.putString("altura",altura.getText().toString());
                String pesoString = String.valueOf(peso);
                String alturaString = String.valueOf(altura);
                intent.putExtra("ps",pesoString);
                intent.putExtra("al",alturaString);
                startActivity(intent);
            }
        });




    }
}