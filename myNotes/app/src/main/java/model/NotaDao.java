package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class NotaDao {

    SQLiteDatabase sqLiteDatabase;

    public NotaDao(Context c) {
        this.sqLiteDatabase = c.openOrCreateDatabase("Gerenciador",Context.MODE_PRIVATE,null);
    }
    public boolean insert(Nota nota){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo",nota.titulo);
        contentValues.put("txt",nota.txt);
        sqLiteDatabase.insert("notas" ,null,new ContentValues);
    }
}
