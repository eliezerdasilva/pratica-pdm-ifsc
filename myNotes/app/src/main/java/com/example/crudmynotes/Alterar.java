package com.example.crudmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.crudmynotes.controller.NotaController;
import com.example.crudmynotes.model.Nota;

public class Alterar extends AppCompatActivity {

    private NotaController notaController;
    private EditText editTextTitulo;
    private EditText editTextTexto;
    private Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        notaController = new NotaController(this);
        editTextTitulo = findViewById(R.id.editTextTitulo);
        editTextTexto = findViewById(R.id.editTextTexto);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        selecionarNota();

        Button buttonAlterar = findViewById(R.id.buttonAlterar);
        buttonAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alterarNota();
            }
        });
    }

    private void selecionarNota() {
        Nota nota = notaController.selecionarNota(id);
        if (nota != null) {
            editTextTitulo.setText(nota.getTitulo());
            editTextTexto.setText(nota.getTexto());
        }
    }

    private void alterarNota() {
        String titulo = editTextTitulo.getText().toString();
        String texto = editTextTexto.getText().toString();
        notaController.atualizarNota(id, titulo, texto);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notaController.fecharBancoDados();
    }
}