package controller;

import android.content.Context;

import java.util.ArrayList;

import model.Nota;
import model.NotaDao;

public class NotaController {

    public NotaController(Context c) {
        NotaDao notaDao = new NotaDao(c);
    }
    public boolean cadastrarNota(Nota nota){
        return false;
    }
    public Nota getNota(Integer id){
        return null;
    }
    public ArrayList<Nota> getListaNota(){
        return null;
    }
    public boolean excluitNota(Integer id){
        return false;
    }

}
