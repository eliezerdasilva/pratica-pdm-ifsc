package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase bancoDados;
    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewDados = (ListView) findViewById(R.id.listView);

        criarBancoDados();
        inserirDados();
        listarNotas();
    }

    private void inserirDados() {
        try {
            bancoDados = openOrCreateDatabase("notas", MODE_PRIVATE, null);
            String sql = "INSERT INTO nota(titulo,txt) values(?,?)";
            SQLiteStatement stmt = bancoDados.compileStatement(sql);
            stmt.bindString(1, "eeee");
            stmt.bindString(2, "4");
            stmt.executeInsert();
            bancoDados.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void listarNotas() {
        try{
            bancoDados = openOrCreateDatabase("notas",MODE_PRIVATE, null);
            Cursor cursor = bancoDados.rawQuery("Select id , titulo txt from nota",null);
            ArrayList<String> linha = new ArrayList<>();
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    linha
            );
            listViewDados.setAdapter(arrayAdapter);
            cursor.moveToFirst();
            while (cursor!=null){
                linha.add(cursor.getString(1));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

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