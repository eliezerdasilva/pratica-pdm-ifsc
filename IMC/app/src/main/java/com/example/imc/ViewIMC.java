package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewIMC extends AppCompatActivity {

    private TextView mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_imc);

        mostrar = findViewById(R.id.txtMostrar);
        Intent it=getIntent();
        String pesoST = it.getStringExtra("peso");
        String alturaST = it.getStringExtra("altura");

        Double peso = Double.valueOf(pesoST);
        Double altura = Double.valueOf(alturaST);
        double imc = peso/(altura*altura);
        if(imc>18.5 && imc < 24.99){
        mostrar.setText("Abaixo do peso");
        }else if(imc >= 25 && imc <= 29.99){
            mostrar.setText("Peso normal");
        }else if(imc >=25 && imc <= 34.99){
            mostrar.setText("Sobrepeso");
        }else if (imc >= 30 && imc <= 34.99){
            mostrar.setText("Obesidade grau 1");
        }else if (imc>= 35  && imc <= 39.99){
            mostrar.setText("Obesidade grau 2");
        }else if (imc>40){
            mostrar.setText("Obesidade grau 3");
        }


    }
}