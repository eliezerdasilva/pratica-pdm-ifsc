package model;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NotaDao extends SQLiteOpenHelper {

    private static final String DB_NOTAS = "db_notas";
    private static final String ID = "_id";
    private static final int VERSAO_BANCO = 1;
    private Context ctx;

    private SQLiteOpenHelper SQLiteOpenHelper;
    SQLiteDatabase db = SQLiteOpenHelper.getWritableDatabase();



    public NotaDao(Context context) {
        super(context, DB_NOTAS, null, VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE nota("
                + ID + " integer primary key autoincrement,"
                + " titulo text,"
                + " nota varchar)";


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long salvarNotas(Nota nota){
        ContentValues values = new ContentValues(); //vai armazenar os dados do objeto
        long retornoDB;

        values.put("titulo", nota.getTitulo());
        values.put("txt", nota.getTxt());

       long result = db.insert("nota",null,values);
        return result;
    }
    public boolean atualizarNotas(Nota nota){
        ContentValues values = new ContentValues(); //vai armazenar os dados do objeto

        String sql = "INSERT INTO nota(id,titulo,txt) values(?,?,?);";
        SQLiteStatement stmt = db.compileStatement(sql);
        stmt.bindLong(1,nota.getId());
        stmt.bindString(2, nota.getTitulo());
        stmt.bindString(3, nota.getTxt());
        try {
            db.execSQL(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        db.close();
        return false;

    }
    public boolean deletarNota(Nota nota){
        ContentValues values = new ContentValues();
        String sql = "DELETE from nota where id = "+nota.getId()+";";
        try{
            db.execSQL(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<Nota>listNota(){
        ContentValues values = new ContentValues();
        String sql = "select * from nota; ";
        Nota nota = new Nota();

        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Nota> listNotas = new ArrayList<Nota>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            nota.setId(cursor.getInt(0));
            nota.setTitulo(cursor.getString(1));
            nota.setTxt(cursor.getString(2));
            listNotas.add(nota);
            cursor.moveToNext();

        }
        return listNotas;
    }

}
