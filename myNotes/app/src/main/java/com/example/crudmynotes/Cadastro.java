package com.example.crudmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.crudmynotes.controller.NotaController;

public class Cadastro extends AppCompatActivity {

    private NotaController notaController;
    private EditText editTextTitulo;
    private EditText editTextTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        notaController = new NotaController(this);
        editTextTitulo = findViewById(R.id.editTextTitulo);
        editTextTexto = findViewById(R.id.editTextTexto);

        Button botao = findViewById(R.id.buttonCadastrar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarNota();
            }
        });
    }

    private void cadastrarNota() {
        String titulo = editTextTitulo.getText().toString();
        String texto = editTextTexto.getText().toString();

        if (!TextUtils.isEmpty(titulo) && !TextUtils.isEmpty(texto)) {
            notaController.inserirNota(titulo, texto);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notaController.fecharBancoDados();
    }
}