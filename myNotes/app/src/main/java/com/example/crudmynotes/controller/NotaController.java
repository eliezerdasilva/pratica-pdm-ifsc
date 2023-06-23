package com.example.crudmynotes.controller;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.crudmynotes.model.Nota;

import java.util.ArrayList;


public class NotaController {
    private SQLiteDatabase bancoDados;

    public ArrayList<Integer> arrayIds;

    public NotaController(Context context) {
        bancoDados = context.openOrCreateDatabase("notas", MODE_PRIVATE, null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS nota(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT," +
                "texto TEXT)");
    }

    public void fecharBancoDados() {
        if (bancoDados != null)
            bancoDados.close();
    }

    public long inserirNota(String titulo, String texto) {
        ContentValues valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("texto", texto);
        return bancoDados.insert("nota", null, valores);
    }

    public void atualizarNota(int id, String titulo, String texto) {
        ContentValues valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("texto", texto);
        String[] whereArgs = {String.valueOf(id)};
        bancoDados.update("nota", valores, "id = ?", whereArgs);
    }

    public void excluirNota(int id) {
        String[] whereArgs = {String.valueOf(id)};
        bancoDados.delete("nota", "id = ?", whereArgs);
    }

    public ArrayList<Nota> listarNotas() {
        ArrayList<Nota> notas = new ArrayList<>();
        Cursor cursor = bancoDados.rawQuery("SELECT id, titulo, texto FROM nota", null);
        if (cursor != null) {
            int idColumnIndex = cursor.getColumnIndex("id");
            int tituloColumnIndex = cursor.getColumnIndex("titulo");
            int textoColumnIndex = cursor.getColumnIndex("texto");

            while (cursor.moveToNext()) {
                int id = cursor.getInt(idColumnIndex);
                String titulo = cursor.getString(tituloColumnIndex);
                String texto = cursor.getString(textoColumnIndex);
                Nota nota = new Nota(id, titulo, texto);
                notas.add(nota);
            }
            cursor.close();
        }
        return notas;
    }


    public Nota selecionarNota(int id) {
        Nota nota = null;
        String[] whereArgs = {String.valueOf(id)};
        Cursor cursor = bancoDados.rawQuery("SELECT id, titulo, texto FROM nota WHERE id = ?", whereArgs);
        if (cursor.moveToFirst()) {
            String titulo = cursor.getString(1);
            String texto = cursor.getString(2);
            nota = new Nota(id, titulo, texto);
        }
        cursor.close();
        return nota;
    }
    public ArrayList<Nota> filtroTitulo(String titulo) {
        ArrayList<Nota> notas = new ArrayList<>();
        String[] whereArgs = {String.valueOf(titulo)};
        Cursor cursor = bancoDados.rawQuery("SELECT id, titulo, texto FROM nota where titulo = ? ",whereArgs);
        if (cursor != null) {
            int idColumnIndex = cursor.getColumnIndex("id");
            int tituloColumnIndex = cursor.getColumnIndex("titulo");
            int textoColumnIndex = cursor.getColumnIndex("texto");

            while (cursor.moveToNext()) {
                int id = cursor.getInt(idColumnIndex);
                String tituloNovo = cursor.getString(tituloColumnIndex);
                String texto = cursor.getString(textoColumnIndex);
                Nota nota = new Nota(id, tituloNovo, texto);
                notas.add(nota);
            }
            cursor.close();
        }
        return notas;

    }
}
