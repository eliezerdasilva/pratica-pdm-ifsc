package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import model.Nota;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NovaNotaActivity extends AppCompatActivity {
    Intent intent = getIntent();
    private TextView titulo;
    private TextView notaView;
    private Nota nota;
    private Button btnAlterar;
    private Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_nota);
        titulo = findViewById(R.id.txtTitulo);
        notaView = findViewById(R.id.txtNota);

        if (intent != null) {
            nota = new Nota();
            nota = (Nota) intent.getParcelableExtra("nome_pessoa");
        }
        titulo.setText(nota.getTitulo());
        notaView.setText(nota.getTxt());
        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}