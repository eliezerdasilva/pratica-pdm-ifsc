package com.example.atividade06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button conta;
    private TextView mostrar;
    private int soma = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conta = (Button) findViewById(R.id.ButtonContaCLicks);
        mostrar = (TextView) findViewById(R.id.mostrar);

        conta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void contaClicks(View view) {
            soma = soma +1;
            String numero = String.valueOf(soma);
            mostrar.setText("Contador de Cliks"+numero);
            }
        });

    }
}