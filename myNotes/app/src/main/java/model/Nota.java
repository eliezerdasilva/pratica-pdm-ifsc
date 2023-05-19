package model;

public class Nota {
    Integer id;
    String titulo;
    String txt;

    public void Nota(){}

    public Nota(String titulo, String txt) {
        this.titulo = titulo;
        this.txt = txt;
    }

    public Nota(Integer id, String titulo, String txt) {
        this.id = id;
        this.titulo = titulo;
        this.txt = txt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
