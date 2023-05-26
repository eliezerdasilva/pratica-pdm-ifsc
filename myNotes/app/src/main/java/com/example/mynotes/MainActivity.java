package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import model.Nota;
import model.NotaDao;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase bancoDados;
    public ListView listViewDados;
    ArrayList<Nota> listNotas = new ArrayList<Nota>();
    private ListView listViewNotas;
    private Nota nota;
    private NotaDao notaDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewDados = (ListView) findViewById(R.id.listView);

        listarNotas();
        bancoDados = openOrCreateDatabase("notas", MODE_PRIVATE, null);
        bancoDados.close();
        listViewNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Ação a ser executada quando um item da lista for clicado
                nota = new Nota();
                nota = listNotas.get(position);
                Intent intent = new Intent(MainActivity.this, NovaNotaActivity.class);
                intent.putExtra("nota", nota);
                startActivity(intent);

            }
        });
    }



    private void inserirNotas(Nota nota) {

        ContentValues contentValues = new ContentValues();
        try {

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void listarNotas() {
        ContentValues valores;
        bancoDados = notaDao.getWritableDatabase();
        listNotas = notaDao.listNota();
        ApplicationAdapter  notaAdapter = new ApplicationAdapter(this, android.R.layout.simple_list_item_1, listNotas);
        listViewNotas.setAdapter(notaAdapter);

    }

    private void criarBancoDados() {
        try{
            bancoDados = openOrCreateDatabase("notas",MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS nota("+
                    "id Integer primary key autoincrement"+
                    ", titulo  Varchar"+
                    ", txt Varchar )");
            bancoDados.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}