package com.example.pratica_24_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textview;
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.txtValor);
        textview.setText(Integer.toString(contador));
    }
    public void mudaTexto(View v){
        Button button = (Button) v;
        button.setText("opa");
        contador++;
       textview.setText(contador);
    }
}