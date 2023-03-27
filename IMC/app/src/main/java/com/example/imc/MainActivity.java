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
        EditText pesotxt = findViewById(R.id.txtPeso);
        EditText alturatxt = findViewById(R.id.txtAltura);
        conta.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewIMC.class);

                double peso = Double.parseDouble(pesotxt.getText().toString());
                double altura = Double.parseDouble(alturatxt.getText().toString());



                intent.putExtra("peso",peso);
                intent.putExtra("altura",altura);
                  intent.putExtras(intent);

                startActivity(intent);
            }
        });




    }
}