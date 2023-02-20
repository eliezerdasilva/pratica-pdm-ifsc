package com.example.atividade07;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView res;
    private EditText numero1;
    private EditText numero2;
    private Button sorteia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        numero1 = findViewById(R.id.txtnumero1);
        numero2 = findViewById(R.id.txtnumero2);
        sorteia = findViewById(R.id.sortear);
        res = findViewById(R.id.txtresultado);

        sorteia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int n1 = Integer.parseInt(String.valueOf(numero1.getText()));
                int n2 = Integer.parseInt(String.valueOf(numero2.getText()));
                if(n1 <= n2) {
                    int resut = n2 - n1 + 1;

                    int numero1 = (int) (Math.random()  *resut) + n1;


                    res.setText("Resultado" + numero1);
                }else {
                    res.setText("Resultado invalido");
                }
                }
        });

    }
}